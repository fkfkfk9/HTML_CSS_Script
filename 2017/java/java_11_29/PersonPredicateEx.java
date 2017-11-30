package java_11_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PersonPredicateEx {

	private static List<Person> list = Arrays.asList(
			new Person(1, "홍길동", 30),
			new Person(2, "박찬호", 50),
			new Person(3, "허재", 53),
			new Person(4, "선동열", 56)
	);
	public static double ageAvg(Predicate<Person> predicate) {
		int count = 0, sum = 0;
		for(Person p : list) {
			if(predicate.test(p)) {
				count++;
				sum += p.getAge();
			}
		}
		return (double) sum / count;
	}
	public static ArrayList<String> nameList(Predicate<Person> predicate) {
		ArrayList<String> namelist = new ArrayList<String>();
		for(Person p : list) {
			if(predicate.test(p)) {
				namelist.add(p.getName());
			}
		}
		return namelist;
	}
	
	public static void main(String[] args) {
		double oddAvg = ageAvg( t ->  t.getIdx()%2!=0);
		System.out.println("홀수 번호의 나이 평균 : " + oddAvg);
			
		ArrayList<String> namelist = nameList( t ->  t.getAge()>=50 );
		System.out.print("나이가 50이상인 사람 : | ");
		for (String name : namelist) {
			System.out.print(name + " | ");
		}
	}

	
}

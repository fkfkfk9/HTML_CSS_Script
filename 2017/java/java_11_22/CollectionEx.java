package java_11_22;

import java.util.ArrayList;

public class CollectionEx {

	public static void main(String[] args) {
		//제네릭스 등장배경
		ArrayList al = new ArrayList<>();
		//아래의 4개 add는 내부적으로 자동 형변환이 일어나서 저장된다.
		//원래 ArrayList는 오브젝트를 저장하는거고 자동으로 (Object)가 붙어서 저정된다.
		al.add(10);//int형 데이터
		al.add(10.0);//double형 데이터
		al.add("대한민국");//String형 데이터
		al.add(new Person("유종현", "경기도 안양시"));//class형 데이터
		//데이터를 다시 받아올때는 형변환을 해줘야한다.
		int num = (int)al.get(0);
		Person p = (Person)al.get(3);
		//제네릭스 버전
		//데이터 형을 적어주기 때문에 형변환의 고민을 할필요도 없고 성능도 개선
		//만약 여러타입의 데이터를 넣어줄거라면 Object를 넣어주면 된다.
		ArrayList<Person> alP = new ArrayList<Person>();
		alP.add(new Person("유종현", "경기도 안양시"));
		alP.add(new Person("홍길동", "조선"));
		alP.add(new Person("손흥민", "런던"));
		System.out.println(alP.get(0).name + " : " + alP.get(0).address);
		System.out.println(alP.get(1).name + " : " + alP.get(1).address);
		System.out.println(alP.get(2).name + " : " + alP.get(2).address);
		ArrayList<Integer> iAl = new ArrayList<Integer>();
		iAl.add(10);
		num = iAl.get(0);
		System.out.println(num);
	}

}

class Person{
	String name;
	String address;
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
}

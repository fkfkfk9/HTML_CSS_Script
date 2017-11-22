package java_11_22.generic.ex1;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyDemo2 {

	public static void main(String[] args) {
		Family2<String> f1 = new Family2<String>(100, "홍길동", "남자");
		Family2<String> f2 = new Family2<String>(80, "춘향이", "여자");
		Family2<String> f3 = new Family2<String>(60, "홍길순", "여자");
		Family2<String> f4 = new Family2<String>(55, "홍길남", "남자");
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		
		ArrayList<Family2> objFamily = new ArrayList<>();
		objFamily.add(new Family2<>(100, "홍길동", "남자"));
		objFamily.add(new Family2<>(80, "춘향이", "여자"));
		objFamily.add(new Family2<>(60, "홍길순", "여자"));
		objFamily.add(new Family2<>(55, "홍길남", "남자"));
		
		Iterator<Family2> iter = objFamily.iterator();
		while(iter.hasNext()) {
			Family2 f = iter.next();
			System.out.println(f);
		}
	}
}

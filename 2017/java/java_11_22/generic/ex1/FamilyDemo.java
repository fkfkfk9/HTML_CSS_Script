package java_11_22.generic.ex1;

import java.util.ArrayList;

public class FamilyDemo {

	public static void main(String[] args) {
		ArrayList<Family> alF = new ArrayList<>();
		Family<String> fs = new Family<>(100, "홍길동", "남자");
		alF.add(fs);
		alF.add(new Family<String>(80, "춘향이", "여자"));
		alF.add(new Family<String>(60, "홍길순", "여자"));
		alF.add(new Family<String>(55, "홍길남", "남자"));
		
		System.out.println("가족의 인원 : " + Family.count);
		System.out.println(printFamily(alF));//printFamily메소드
		System.out.println(printGeneric(alF));
	}
	public static String printFamily(ArrayList<Family> alF) {
		String str = "";
		for (int i = 0; i < alF.size(); i++) {
			str += "나이 : " + alF.get(i).getAge() + ", 이름 : " + alF.get(i).getName() 
					+ ", 성별 : " + alF.get(i).getGender() + "\n"; 
		}
		return str;
	}
	public static <T>String printGeneric(T t){
		return t.toString();//toString
	}
}

package java_11_02;

public class Variable {//클래스 변수명은 첫글자를 대문자로한다.

	public static void main(String[] args) {
		//변수를 선언하는법
		int a;
		int b;
		int c,d;
		int e;int f;
		int month;
		//변수 초기화
		int age = 30;//선언과 초기화를 동시에
		month = 0;
		System.out.println("******변경전******");
		System.out.println("age : " + age);
		System.out.println("month : " + month);
		System.out.println("----------------");
		age++;
		month = month + 11;
		System.out.println("******변경후******");
		System.out.println("age : " + age);
		System.out.println("month : " + month);
		System.out.println("----------------");
	}

}

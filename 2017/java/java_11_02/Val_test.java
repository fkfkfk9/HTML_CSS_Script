package java_11_02;

public class Val_test {

	public static void main(String[] args) {		
		int num1 = 13;
		int num2 = 22;
		int temp = 0;
		
		System.out.println("------- 변경 전 -------");
		System.out.println("num1 : "+ num1 + "  num2 : " + num2);				
		
		temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("------- 변경 후 -------");
		System.out.println("num1 : "+ num1 + "  num2 : " + num2);
	}
}

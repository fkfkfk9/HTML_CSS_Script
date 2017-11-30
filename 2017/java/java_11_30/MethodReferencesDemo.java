package java_11_30;

import java.util.function.IntBinaryOperator;

public class MethodReferencesDemo {

	public static void main(String[] args) {
		//함수적 인터페이스의 참조변수를 선언하게 되면
		//해당 추상메서드의 람다식으로 재정의된 코드를 대입해서 사용하는 특징
		
		IntBinaryOperator ibop;//추상메서드 int applyAsInt(int, int)
		
		ibop = (num1,num2) -> Num.adder(num1, num2);
		System.out.println("10과 20의 합은 : " + ibop.applyAsInt(10, 20));
		
		ibop = Num::adder;//위의 코드보다 더 줄일 수 있다.
		//메서드 참조표현 : 매개변수와 메서드의 매개변수와 같다면 매개변수도 제거 가능
		//클래스명 :: 메서드명
	}

}

class Num{
	public static int adder(int num1, int num2) {
		return num1 + num2;
	}
}
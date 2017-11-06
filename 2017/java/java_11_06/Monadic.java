package java_11_06;

public class Monadic {//단항연산자 테스트

	public static void main(String[] args) {
		int num1 = 8, num2 = 0;
		
		num2 = num1++;//먼저 num2에 값을 대입하고 num1의 증가 연산자가 동작
		System.out.println("num++을 실행한 뒤 num1 : " + num1 + " num2 : " + num2);
		
		num2 = ++num1;//먼저 num2의 증가연산자가 진행되고 num2에 대입
		System.out.println("++num을 실행한 뒤 num1 : " + num1 + " num2 : " + num2);
		
		System.out.println(num1++);//증가연산을 하기 전에 출력
		System.out.println(++num2);//증가하고 출력
		System.out.println("num1의 현재 값 : " + num1 + " num2의 현재 값 : " + num2);
	}

}

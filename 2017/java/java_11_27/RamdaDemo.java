package java_11_27;

public class RamdaDemo {

	public static void main(String[] args) {
		String name = "유종현";
		System.out.println();
	}
}

class RamdaEx{
	//기본 메소드
	int max(int num1, int num2) {//메소드 선언부
		return num1 > num2 ? num1 : num2;//실행부
	}
	//람다식 변환 : 메소드명 리턴타입이 빠지는 간편하게 표현하는 방법
//	(int num1, int num2) -> {return num1 > num2 ? num1 : num2;}
//	(int num1, int num2) -> num1 > num2 ? num1 : num2;위의 식과 같은 의미이다.
//	(num1, num2) -> num1 > num2 ? num1 : num2 3가지는 같은의미로 축약을 여기까지 할 수 있다.
	//컴파일러가 형을 유추해서 매개변수의 데이터타입까지 정해서 처리해준다.
	int method1(int num) {
		return num;
	}
	//람다식
//	(int a) -> {return a}
//	a -> a 매개변수가 하나라면 이렇게도 축약 가능
//	a -> a*a 이런식도 가능
//	() -> 10 매개변수가 없다면 괄호만 넣을수도
	void method3() {
		System.out.println("람다식 문법");
	}
//	() -> System.out.println("람다식 문법");
//	name -> "안녕하세요!!" + name;
	/*a,b,c -> {
		double avg = 0;
		avg = (a+b+c)/3.0;
		return avg;
	}*/
	//함수형 인터페이스(메서드가 하나뿐인 인터페이스)를 람다식 문법으로 사용하는 구문.
//	Runnable th1 = run()메서드를 람다식으로 표현
	//Runnable th1 = () -> {}   th1.run()으로 호출
}

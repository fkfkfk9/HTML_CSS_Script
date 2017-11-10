package java_11_10;

public class OverroadingEx {
	
	public static void main(String[] args) {
		OverroadingTest ot = new OverroadingTest();
		ot.methodA();
	}
	
}

class OverroadingTest{
	int a,b,c;
	//int a //같은 변수를 또 사용할 수는 없다.
	
	void methodA() {
		//지역변수는 메서드가 호출시에만 메모리가 생성되고 종료시 자동소멸
		int a = 5;//같은 이름의 변수지만 지역변수이기 때문에 가능
		this.a = 10;//인스턴스 변수
		System.out.println("a = "+a);
		System.out.println("this.a = "+this.a);
	}
	
	void methodB(int a) {
		//매개변수 a 도 지역변수 이다.
	}
	void methodC() {
		int result = a;
	}
	//int methodC() {return 0;}//메서드명이 같으면 에러가 난다.
	//이렇게 메서드명이 나면 에러가 나지 않는 기능이 오버로딩이고 규칙이 있다.
	//오버로딩 : 메서드의 매개변수의 타입과 개수가 다르면 동일한 메서드명을 허용
	void methodC(int a) {//매개변수를 넣어줘서 에러가 사라짐
		this.a = a;
	}
	void methodC(int a, int b) {//매개변수의 개수가 달라도 에러는 없다.
		this.a = a+b;
	}
}
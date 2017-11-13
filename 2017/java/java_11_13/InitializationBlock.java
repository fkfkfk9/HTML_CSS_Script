package java_11_13;

public class InitializationBlock {//초기화 블럭
	static int count = 0;
	//static(클래스) 블럭 : 클래스 멤버를 초기화 하고자 하는 목적
	static {
		System.out.println(++count + ". static 블럭 실행");
		//클래스를 실행하는 순간 실행 메인보다 먼저 실행된다.
	}
	//인스턴스 블럭 : 인스턴스 멤버를 초기화 하고자 하는 목적
	{
		System.out.println(++count + ". 인스턴스 블럭 실행");
		//객체 생성시 생성자보다 먼저 실행
	}
	
	InitializationBlock(){//생성자
		System.out.println(++count + ". 생성자 실행");
		//객체 생성하면서 실행 인스턴스 호출보다 느리다.
	}
	
	public static void main(String[] args) {
		System.out.println(++count + ". 객체 생성");//메인 시작시 실행
		InitializationBlock ib = new InitializationBlock();
		//객체 생성
		System.out.println("----------------------------");
		System.out.println(++count + ". 객체2 생성");
		InitializationBlock ib2 = new InitializationBlock();
	}

}

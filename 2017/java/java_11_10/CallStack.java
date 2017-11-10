package java_11_10;

public class CallStack {
	static int count = 0;//메소드 실행 순서를 표시할 변수
	
	//staric 메서드도 변수 개념과 동일
	//클래스명.메서드명()으로 접근한다.
	public static void main(String[] args) {
		System.out.println(++count + ". 메인 메소드 시작");
		first();//CallStack.first() 가 정석
		//같은 클래스 안에 있는 메소드 이기 때문에 클래스명을 생략한다.
		System.out.println(++count + ". 메인 메소드 끝");
	}
	static void first() {
		System.out.println(++count + ". 첫번째 메소드 시작");
		second();
		System.out.println(++count + ". 첫번째 메소드 끝");
	}
	static void second() {
		System.out.println(++count + ". 두번째 메소드 시작");
		System.out.println(++count + ". 두번째 메소드 끝");
	}
}

package java_11_16;

public class ClassDemo {

	public static void main(String[] args) {
		Class ce1 = new ClassEx().getClass();
		/*Class ce2 = ClassEx.class; 클래스를 받아오는 2번째 방법
		try {3번째 방법
			Class ce3 = Class.forName("ClassEx");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		//Class 클래스는 getClass를 통해 클래스의 정보를 가져온다.
		//클래스에 정의된 멤버의 이름이나 개수 등 모든 정보를 얻을 수 있다.
		
//		ClassEx ce = ClassEx.class.newInstance();//이런식으로 인스턴스 생성가능 예외처리 필요
		ClassEx ce = new ClassEx();
		
		System.out.println(ce);
		System.out.println(ce1.getName());//패키지명.클래스명까지
		System.out.println(ce1.toGenericString());//파이널까지 표시
		System.out.println(ce1.toString());//클래스 패키지명.클래스명까지
		/*
			리플렉션(Reflection) : 역방향, 이미 만들어진 클래스를 참조해서 객체생성
								 동적으로 객체를 생성하고 메서드를 호출하는 방법이다.
		*/
	}

}

final class ClassEx{
	int num1;
	int num2;
	
	public ClassEx() {
		this.num1 = 8;
		this.num2 = 13;
	}
	@Override
	public String toString() {
		return num1 + ", " + num2;
	}
}


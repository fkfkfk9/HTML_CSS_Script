package java_11_27;

public class MyFunctionTest {

	public static void main(String[] args) {
		MyFungtion mf;
		mf = () -> {System.out.println("람다식으로 구현한 함수형 인터페이스");};
		mf.methodA();
	}

}

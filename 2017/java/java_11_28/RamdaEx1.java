package java_11_28;

import java_11_27.MyFungtion;

public class RamdaEx1 {

	public static void main(String[] args) {
		RamdaFinal rf = new RamdaFinal();
		rf.ramdamet(33);
	}

}

class RamdaFinal{
	void ramdamet(int arg) {
		int iv = 50;
		
//		arg = 33;람다식에서 변수를 사용하는 순간 파이널 성격이되어 변경시도시 에러가 난다.
		MyFungtion mf;
		mf = () -> {
			System.out.println("람다식으로 구현한 함수형 인터페이스");
			System.out.println("iv : " + iv);
			System.out.println("arg : " + arg);
		};
		mf.methodA();
	}
}
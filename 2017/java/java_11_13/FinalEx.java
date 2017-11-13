package java_11_13;

public class FinalEx {

	public static void main(String[] args) {
		Aniaml a = new Aniaml();
//		a.leg = 2; 에러 파이널변수는 상수
		a.cry();
	}

}

class Aniaml{
	final int leg = 4;//상수처럼 값을 더 이상 변경 불가
	
	final void cry() {//상속 받은 클레스에서 오버 라이딩을 할 수 없다.
		System.out.println("아~우~");
	}
}

final class Dog extends Aniaml{//이제 Dog는 final이 붙었기 때문에 더 이상 상속되지 못한다.
	/*void cry() {//에러 더 이상 오버라이딩 할 수 없다.
		System.out.println("멍! 멍!");}*/
}
//class Pudel extends Dog{} 에러 더 이상 Dog는 조상이 될 수 없다.
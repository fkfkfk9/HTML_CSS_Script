package java_11_15;

public class AnnoyDemo {//익명클래스
	public static void main(String args[]) { 
        Annoy a = new Annoy();
        System.out.println(a.toString());
  } 
}
//익명클래스는 윈도우의 이벤트 프로그래밍이나
//안드로이드 이벤트 프로그래밍 방식에 자주 등장한다.
class Annoy{
	Object obj = new Object();
	//익명클래스
	Object Obj2 = new Object() {//익명클래스의 부모클래스나, 인터페이스가 온다.
		//익명클래스 구성요소
		void method() {
			System.out.println("익명클래스");
		}
	};
}

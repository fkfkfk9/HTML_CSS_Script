package java_11_15;

import java_11_15.Outer2.InnerClass;
import java_11_15.Outer2.StaticInner;

public class Nested {//중첩클래스

	public static void main(String[] args) {
		System.out.println(InnerClass.IFSIV + ", " + StaticInner.ssiv);
		//이너 클래스 사용
	}

}

//내부클래스(중첩클래스, Nested Class)
class Outer{//외부클래스
	int iv = 0;//인스턴트 변수 : 객체가 사용되는 동안 기억장소 유지
	static int siv = 0;//스테틱 변수
	
	void method() {
		int liv = 0;//지역변수 : 메소드 실행시에만 생성되어 사용 메소드 끝날때 소멸
	}
}

class Outer2{
	int a = 0;
	static int b = 0;//내부클래스와 일반 변수는 같이 쓸 수 있다.
	InnerClass ic = new InnerClass();//클래스 내부에서 인스턴스, 스테틱 내부 클래스 선언가능
	StaticInner si = new StaticInner();
//	LocalInner li = new LocalInner();지역 클래스는 외부에서 접근 불가
	class InnerClass{//인스턴스 클래스
		int iiv = 13;
//		static int isiv = 8;인스턴스 클래스이기 때문에 스테틱이 적용안된다.
		final static int IFSIV = 8;//상수는 가능하다.
	}
	static class StaticInner{//스테틱 클래스
		int siv = 13;
		static int ssiv = 8;//스테틱 변수 가능
	}
	
	void method() {
		class LocalInner{//지역 클래스
			//인스턴스 클래스와 같이 스테틱 불가 상수는 가능
		}
		InnerClass ic = new InnerClass();//인스턴스 멤버 안에서는 둘다 가능
		StaticInner si = new StaticInner();
		LocalInner li = new LocalInner();//선언한 메소드에서만 접근가능
	}
	static void staticMethod() {
		//스테틱 멤버안에서는 인스턴스 멤버에 접근 불가
//		InnerClass ic = new InnerClass();
		StaticInner si = new StaticInner();//스테틱 내부 클래스는 가능
		//구지 인스턴트 내부 클래스를 사용하려면 외부객체를 생성후 가능하다.
		Outer2 o2 = new Outer2();
		InnerClass ic = o2.new InnerClass();
	}
}
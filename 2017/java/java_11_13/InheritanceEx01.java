package java_11_13;

public class InheritanceEx01 {

	public static void main(String[] args) {
		//상속시 new연산자는 최상위 클래스의 메로리생성및 생성장 메서드의 실행이 된다.
		//그리고, 순서대로 반복적인 작업을 한다.
		Son s = new Son();
		System.out.println(s.grandFA);
		System.out.println(s.grandFB);
		System.out.println(s.fA);
		System.out.println(s.fB);
		System.out.println(s.sA);
		System.out.println(s.sB);
	}

}

class GrandFather{
	int grandFA;
	int grandFB;
	
	GrandFather(){
		System.out.println("GrandFather생성");
		this.grandFA = 1;
		this.grandFB = 2;
	}
}

class Father extends GrandFather{
	/*
		int grandFA;
		int grandFB;
		상속을 받았기 때문에 표시는 안되도 이 두개 멤버가 있는것이다.
	*/
	int fA;
	int fB;
	
	Father(){
		System.out.println("Father생성");
		this.fA = 3;
		this.fB = 4;
	}
}


class Son extends Father{
	//상위클래스의 멤버(필드, 메서드)만 상속가능.
	//생성자와 초기화블럭은 상속 불가능
	//상속받은 클래스끼리는 전혀 상관이 없다.(형제x)
	int sA;
	int sB;
	
	Son(){
		System.out.println("Son생성");
		this.sA = 5;
		this.sB = 6;
	}
}
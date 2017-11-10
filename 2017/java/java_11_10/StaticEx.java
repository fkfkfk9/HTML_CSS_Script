package java_11_10;

public class StaticEx {
	int a, b;//인스턴스 변수
	//static int num = a; //스테틱 변수 또한 인스턴트 변수를 넣을 수 없다.
	static int num = new StaticEx().a;//객체를 생성시켜 넣으면 가능
	StaticEx rc = new StaticEx();
	//선언부에선 객체를 만들어도 인스턴스 변수이기 때문에 사용불가
//	static int num2 = rc.a;//객체 변수를 만들어 넣는건 불가능
	static StaticEx src = new StaticEx();
	static int num3 = src.a;//스테틱 객체로 만들면 사용가능
	
	/*
	static메서드
	1)인스턴스 변수, 인스턴스 메서드는 사용 불가능
	2)static변수, 메서드는 사용가능
	
	인스턴스 메서드
	1)인스턴스 변수, 메서드는 사용가능
	2)static변수, 메서드도 사용가능
*/
int methodA() {
	
	return a+b;//인스턴스 변수를 사용
}
static int methodB(int a, int b) {//매개변수 사용시 static를 권장
	new StaticEx().a = 10; //객체를 생성하면서 접근하는건 에러가 없다.	
	return a+b;//매개 변수를 사용
	//인스턴스 변수를 사용한다면 static사용시 에러가 난다.
}
}

package java_11_10;

public class Variable {
	//인스턴스 변수 : 객체를 생성해서 접근해야 한다. 객체명.필드(변수)
	int iNum1;
	int iNum2;
	
	//클래스 변수(static변수, 공유변수) : 객체를 생성하지 않아도 접근가능 클래스명.필드(변수)
	//객체를 생성할 때 static변수는 객체에 포함되지 않는다.
	static int siNum;
	
	void method() {
		int miNum;//지역변수
	}
}

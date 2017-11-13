package java_11_13;

public class AccessEx {//접근제어자
	/*
	 	private : 같은 클래스 내에서만 접근이 가능
	 	default : 같은 패키지 내에서만 접근이 가능//접근제어자에 아무것도 안넣었을 경우
	 	protected : 같은 패키지 내에서, 다른 패키지의 자손클래스에서 접근가능
	 	public : 접근제한이 없다.
	*/	
	public static void main(String[] args) {
		
	}

}

//public class Ac 에러가 난다. public는 클래스 파일에서 하나밖에 넣지 못함
//public가 들어가는 클래스는 파일명이어야 한다.
class Sum{
	private int num1;//private는 변수에 직접 접근하는것을 막아준다.
	private int num2;//직접 접근이 불가능하기 때분에 getter, setter필수
	//외부로 부터 데이터를 보호하고 외부에선 불필요하고 내부에서 사용되는 부분을 감추기 위해
	//이런 기능을 객체 지향에서는 캡슐화라고 부른다.
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	
}
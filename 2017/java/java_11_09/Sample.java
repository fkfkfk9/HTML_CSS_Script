package java_11_09;

public class Sample {
	public static void main(String[] args) {
		Arithmethic at = new Arithmethic();
		at.setA(77);
		at.setB(55);
		System.out.println("a의 값은 : " + at.getA());
		System.out.println("b의 값은 : " + at.getB());
		System.out.println("a + b의 값은 : " + at.add());
	}
}

class Arithmethic{
	private int a;
	private int b;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		if(a <= 0 || a > 100)System.out.println("a는 1~100까지만 입력가능합니다.");
		else this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		if(b < 50 || b > 60 )System.out.println("b는 50~60까지만 입력가능합니다.");
		else this.b = b;
	}
	
	public int add() {
		return this.a + this.b;
	}
}

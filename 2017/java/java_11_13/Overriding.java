package java_11_13;

public class Overriding {
	/*
		Overroading(중복정의) - 동일 클래스내에서 같은 매서드명을 다수 만들수있는 기능 
		Overriding(재정의) - 상속시에 부모클래스에 존재하는 매소드를 자식클래스 입장에서 재정의
	*/
	public static void main(String[] args) {
		adder ae = new adder();
		add a = new add();
		ae.methodA();
		a.methodA();		
	}

}

class adder{
	int x, y;
	
	void methodA() {
		System.out.println("x + y = " + (x + y));
	}
	void methodA(int a) {//오버로딩
		x = a;
	}
}

class add extends adder{
	int z;
	void methodA() {//오버라이딩
		System.out.println("x + y + z = " + (x + y + z));
	}
}


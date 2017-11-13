package java_11_13;

public class SuperEx {

	public static void main(String[] args) {
		add2 a = new add2(30);
		a.x = 13;
		a.print();
	}

}

class adder2{
	int x;
	int y;
	
	void methodA() {
		System.out.println("x + y = " + (x + y));
	}
	void methodA(int a) {//오버로딩
		x = a;
	}
	adder2(int num){//생성자 메서드가 존재하면 기본생정자 메서드는 생성이 안된다.
		this.x = num;
	}
	adder2(){}
}

class add2 extends adder2{
	int x = 10;//이 작업을 함으로 써 기존값은 super.x에 현재값은 this.x에 저장된다.
	//x를 다시 정의하지 않는다면 super값은 따로 존재하지 않고 같이 변하게 된다.
	int z;
	void methodA() {//오버라이딩
		System.out.println("x + y + z = " + (x + y + z));
	}
	void print(){
		System.out.println("x = " + x);
		System.out.println("현재 객체의 x : " + this.x);
		System.out.println("부모 객체의 x : " + super.x);
		//super : 상속시 부모의 변수를 다시 정의 한 경우 부모의 멤버를 가리키는 목적
	}
	/*
		부모와 자식에서 모두 생성자를 정의하지 않은 경우 기본은
		생성자(){ super(); } 가 내부적으로 실행되어 객체가 생성된다.
	*/
	add2(int x){
		super(x);//부모의 생성자를 불러온다.
	}
	add2(){ super(); }//그냥 하면 에러가 난다 부모에도 만들고 부모것도 같이 정의해줘야함
	//부모클래스가 생성자를 추가한 순간부터 기본생성자는 없어지기 때문에 기본생성자 코드를 직접 
	//코딩해준다음에 super로 추가를 해줘야 가능
}
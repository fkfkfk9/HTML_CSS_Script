package java_11_14;

public class PolymorphismEx {//Polymorphism : 다형성

	public static void main(String[] args) {
		Cal c1 = new Cal();
		Cal c2 = new Cal(20, 30);
		Add a1 = new Add(10, 20);
		Add a2 = null;
		
		//업캐스팅 : 자식클래스의 타입을 부모클래스의 타입으로 변환하는것
		//다운캐스팅 : 업캐스팅의 반대 부모클래스의 타입을 자식클래스로 변환
		//부모클래스의 참조변수로 자식클래스의 메서드를 호출 불가능
		c1 = a1;// c1 = (Cal)a1;이 생략된 형태
//		c1.adder();//c1은 adder()이 포함된 메모리를 가지고 있지만 사용할 수는 없다.
//		a2 = (Add)c2;
//		이클립스상 오류는 없지만 컴파일시 에러가 난다. c2보다 확장되있는 a2이므로 사용불가
//		c2를 업캐스팅을 통해 확장되있는 상태라면 다시 다운캐스팅이 가능하다.
		a2 = (Add)c1;//조상타입에서 자손타입은 형변환시 생략 불가
		//이미 업캐스팅을 했던 객체는 다운캐스팅해도 되지만 아니라면 다운캐스팅 불가
		int sum = a2.adder();
		//Cal객체였던 c1은 adder메소드가 있어도 사용불가능 했지만 그 Cal을 다시 
		//Add객체인 a2로 복사하자 adder메소드를 사용 할 수 있게 되었다.
		System.out.println("sum = " + sum);

	}

}

class Cal{//계산기
	private int num1;
	private int num2;
	
	Cal(){}
	Cal(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	
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
class Add extends Cal{
	Add(){}
	Add(int x, int y){
		super(x, y);
		this.setNum1(x);
		this.setNum2(y);
	}
	int adder() {
		return this.getNum1() + this.getNum2();
	}
}
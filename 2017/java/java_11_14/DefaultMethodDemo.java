package java_11_14;

public class DefaultMethodDemo {
	/*	Default Method
		jdk_1.8부터 새로 추가 된 기능
		인터페이스는 원래 정의만 해놓고 내용은 추가하지 않는대
		Default를 넣으면 인터페이스에서도 실제 메소드처럼 만들 수 있다.
	*/
	public static void main(String[] args) {
		Dog2 d = new Dog2();
		Wolf w = new Wolf();
		d.cry();
		w.cry();
		Animal2.run();
		
		//instanceof 왼쪽의 객체가 오른쪽의 객체에 속하는지 판단
		//d객체는 Dog2로 만들었기때문에 Dog2객체에 속한다.
		if(d instanceof Dog2) {
			System.out.println("d객체는 Dog2클래스에 속한다.");
		}
		//Animal는 인터페이스이기 때문에 d가 상속은 받았지만 속하지 않는다.
		if(d instanceof Animal) {
			System.out.println("d객체는 Animal인터페이스에 속하지 않는다.");
		}
		//Object는 모든 클래스의 조상이기때문에 d는 그 안에 포함된다.
		if(d instanceof Object) {
			System.out.println("d객체는 Object에 속한다.");
		}
		//자손객체에는 속하지 않는다.
		if(d instanceof Pome) {
			System.out.println("d객체는 Pome에 속하지 않는다.");
		}
		//여기 나오지 않지만 객체는 instanceof에서 조상클래스에 포함되게된다.
	}
}

interface Animal2{
	default void cry() {
		System.out.println("아~우~~");
	}
	static void run() {
		System.out.println("Run!~ Run!~");
	}
}

class Dog2 implements Animal2{
	public void cry() {
		System.out.println("멍! 멍!");
	}
}
class Wolf implements Animal2{
	
}
class Pome extends Dog2{
	
}
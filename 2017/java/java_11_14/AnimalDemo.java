package java_11_14;

interface Animal{//인터페이스 생성
	void cry();//추상메서드
	void run();//추상메서드	
}

class Dog implements Animal{//인터페이스를 상속받는다.
	@Override
	public void cry() {//추상메소드 내용을 넣어 완성시킨다.
		System.out.println("멍! 멍! 짓다");		
	}
	@Override
	public void run() {
		System.out.println("개가 달린다.");
	}	
}
class Cat implements Animal{
	@Override
	public void cry() {
		System.out.println("야옹 야옹 소리내다");			
	}
	@Override
	public void run() {
		System.out.println("고양이가 달린다.");			
	}	
}

class AnimalManage{//인터페이스의 다형성을 활용하기 위한 클래스
	Animal call(String animal) {//리턴타입 Animal인터페이스 매개변수 String
		if(animal.equals("Dog")) return new Dog();//String가 Dog가 오면
		//Animal을 상속받은 클래스인 Dog클래스를 객체생성해 리턴시킨다.
		else if(animal.equals("Cat")) return new Cat();
		else {
			System.out.println("현재는 Dog와 Cat만 입력 가능");
			return null;
		}
	}
	void call(Animal ani) {
		//Animal인터페이스 또는 Animal을 상속받는 모든 클래스를 매개변수로 받는 메서드
		ani.cry();//매개변수로 오는 객체들의 cry메서드를 실행 시킨다.
		ani.run();
	}
}

public class AnimalDemo {

	public static void main(String[] args) {
		String str = "Dog";//매개변수로 넣어줄 String변수

		Animal ani = new AnimalManage().call(str);
		//인터페이스를 선언하고 인터페이스를 상속받는 클래스를 매개변수로 정의하는
		//다형성을 활용한 ani변수 str변수의 값인 Dog에 따라 Dog클래스 객체가 된다.
		ani.cry();//Dog객체의 cry메소드 실행
		ani.run();
		AnimalManage am = new AnimalManage();//AnimalManage객체 생성
		am.call(new Cat());//AnimalManage클래스의 call은 Animal을 상속받는 클래스를
		//매개변수로 받는다. Cat 객체를 생성시켜 매개변수로 넣어준다.
	}
}

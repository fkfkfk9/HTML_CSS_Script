package java_11_14;

public class AbstractDemo {//추상클래스, 메소드 데모

	public static void main(String[] args) {
//		Player p = new Player();에러 추상클래스는 생성해서 사용 불가
		Player p = new AudioPlayer(300);
		p.play(60);
		p.stop();
	}
}

abstract class Player{//추상클래스(일반클래스 + 추상메서드)
	//추상클래스와 인터페이스는 객체를 생성하기 위한 목적이 아니라 상속을 지원하기 위한 것이다.
	int a;//추상클래스엔 일반 변수도 들어갈 수 있다.
	 Player(int a){//추상클래스엔 생성자 메소드도 가질 수 있다.
		 this.a = a;
	 }
	 Player(){}
	//추상메서드 : 실행코드부분은 생략하고 선언부분만 존재		
	void f2() {}//추상클래스에 일반 메소드도 들어갈 수 있다.
	abstract void play(int pos);//abstract를 붙여야 추상메소드가 된다.
	//그냥abstract만 붙여서는 에러가 나고 class앞에도 붙여 추상클래스화 해야한다.
	abstract void stop();
}

class AudioPlayer extends Player{//추상메서드를 구현하지 못하면 에러가 난다.
	AudioPlayer(int a){
		super(a);
	}
	void play(int pos) {
		System.out.println( pos + "초 부터 " + this.a + "초까지 음악재생");
	}
	void stop() {
		System.out.println("음악 정지");
	}
}
abstract class AbstractPlayer extends Player{
	abstract void start();//추상클래스를 상속받아 또 추상메소드를 추가하면
	//다음에 상속받는 클래스가 3개의 메소드를 상속해야한다.
}

abstract class AbstractPlayer2 extends Player{
	@Override
	void play(int pos) {//하나의 추상메소드만 정의하고 싶어도 클래스는 추상클래스가 되야한다.
		// TODO Auto-generated method stub
		
	}
}
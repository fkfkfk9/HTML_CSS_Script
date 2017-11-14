package java_11_14;

public class InterfaceDemo {

	public static void main(String[] args) {
//		Player p = new Player(); 인터페이스 또한 객체생성 불가
		Player2 p = new AudioPlayer2();//인터페이스도 자손클래스로 생성가능
		AudioPlayer2 ap = new AudioPlayer2();
		ap.play(50);
		p.play(100);//인터페스도 실행이 된다.
		Player2 p2 = PlayerManager.getPlayer("Audio");
		p2.stop();
	}
}

interface Player2{//인터페이스는 abstract 빠진다.
	//추상 클래스와 비슷하지만 추상클래스보다 더 생략된 추상메서드 + 상수변수만 정의가능
	//즉 일반클래스의 특성이 완전히 사라진다. 오로지 상속만을 위한 것이다.
	
	int A = 33;//인터페이스는 변수 선언시 public static final이 생략되지만 디폴트이다.
	//다른 스테틱 변수처럼 사용가능
	void play(int pos);//public abstract가 생략되어있다.
	void stop();
}

interface newPlayer extends Player2{//인터페이스가 인터페이스를 상속할때는 extends를 사용	
	void start();
}

abstract class newPlayer2 implements Player2, newPlayer{//인터페이스는 2개도 연결됨
	abstract void move();
}
//일반 클래스와 인터페이스를 같이 상속받을 수 있다.
class newPlayer3 extends AudioPlayer2 implements newPlayer{
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}	
}
class PlayerManager{
	public static Player2 getPlayer(String str) {//인터페이스를 리턴형으로 할 수 있다.
		if(str.equals("Audio")) {
			return new AudioPlayer2();//인터페이스를 상속하는 클래스를 리턴할 수 있다.
		}else {
			return new newPlayer3();
		}
	}
}

class AudioPlayer2 implements Player2 {
	@Override
	public void play(int pos) {
		System.out.println( pos + "초 부터 실행");		
	}
	@Override
	public void stop() {
		System.out.println("실행 정지!!");
	}
}
package java_11_23;

import java.awt.Toolkit;

public class ThreadDemo2 {
	public static void main(String[] args) {
		/*
			작업 쓰래드를 사용하려면 Runnable의 run()메소드에 새로 생성한 쓰레드가
			작업할 내용을 담고 있어야 하고 이런 방법으로는 
			1)Runnable을 상속받는 클래스를 만들어	run()을 오버라이딩하여 
			클래스를 사용하여 객체를 만들어 쓰레드 객체생성 매개변수로 넣어서 사용
			2)아래처럼 Runnable객체를 생성하여 생성과 동시에 run()을 오버라이딩 하여
			작업 쓰레드가 작업할 내용을 작성한다. 이후 쓰레드 변수를 생성할때 매개변수로 넣어줌
			3)Thread를 생성하면서 매개변수로 Runnable객체를 생성하고 거기에
			run()를 오버라이딩 한다. - 익명 인터페이스 사용
			4)쓰레드 클래스를 상속받아 run()을 오버라이딩 하고 쓰레드 객체를 생성할때
			new뒤에 상속받은 클래스명을 적어준다.
			5)3)과 비슷한대 new 쓰레드 생성하면서 쓰레드 안의 run()을 오버라이딩하여 사용
			위의 5가지 방법중 쓰레드 클래스를 상속받는것보단 Runnable인터페이스를 상속받는걸 권장
			이유는 인터페이스는 다중상속이 가능한대 쓰래드는 클래스라 단일상속이어서 Runnable
			인터페이스가 좀 더 범용적으로 사용 할 수 있다.
			
			모든 과정이 결국 쓰레드 변수를 생성하고 생성된 쓰레드 객체로 .start();를 실행하면
			메인에서 메인쓰레드가 작업하는 것 외에 작업쓰레드가 run()의 내용을 같이 작업한다.
			만약에 Runnable 변수 .run()으로 실행하게 되면 메인쓰레드가 동작하기 때문에
			의미가 없으므로 꼭 스레드 변수에 넣어 .start를 사용해야한다. 			
		*/
		Runnable ra = new Runnable() {			
			@Override
			public void run() {
				Toolkit tk = Toolkit.getDefaultToolkit();				
				for (int i = 0; i < 3; i++) {
					System.out.println("비프 비프");
					tk.beep();//앞서 메인스레드에서 하던 작업을 작업자 스레드에서
					try {//실행하기 위해 run()에 넣어준다.
						Thread.sleep(333);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}
		};
		Thread t = new Thread(ra);
		t.start();
		for (int i = 0; i < 3; i++) {
			
			System.out.println("Beep!! Beep!!");
			try {
				Thread.sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	}

}

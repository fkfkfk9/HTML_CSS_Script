package java_11_23;

import java.awt.Toolkit;

public class ThreadDemo {
	/*AWT (Abstract Windows Toolkit) - 자바 윈도우 응용프로그램 개발을 위한 라이브러리*/
	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		//소리도 3번 듣고 싶고 출력도 3번을 보려고 만든거지만 순차적으로 출력되는게 아니라 한번에 
		//출력이 된다. 이런 작업들을 순차적으로 보일 수 있도록 쓰레드를 활용한다.
		/*for (int i = 0; i < 3; i++)tk.beep();
		for (int i = 0; i < 3; i++)System.out.println("Beep!! Beep!!");*/
		for (int i = 0; i < 3; i++) {
			tk.beep();
			try {
				Thread.sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Thread.sleep는 사용시 예외처리가 필요하다.
		//Thread.sleep(ms)밀리세컨드가 들어감으로 1000이 1초이다.
		for (int i = 0; i < 3; i++) {
			System.out.println("Beep!! Beep!!");
			try {
				Thread.sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

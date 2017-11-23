package java_11_23;

import java.awt.Toolkit;

public class ThreadDemo3 {
	public static void main(String[] args) {
		/*
			메인쓰레드 이름은 main이다.
			작업쓰레드 이름은 자동으로 Thread-n이라는 이름이 붙는다.
			thread.getName()이름을 받는 에서드 thread.setName()이름을 설정하는 메소드
			Thread.currentTread();실행하고 있는 현재 쓰레드의 정보를 받아옴
		*/
		Thread tMain = Thread.currentThread();
		System.out.println("현재 실행중인 메인 쓰레드의 이름 : " + tMain.getName());
		Thread tEx = new ThreadEx();
		System.out.println("방금 실행시킨 작업쓰레드의 이름 : " + tEx.getName());
		tEx.setName("Thread-Print");
		System.out.println("작업쓰레드의 수정 후 이름 : " + tEx.getName());
		for (int i = 0; i < 13; i++) {
			Thread t = new ThreadEx("TestThread" + i*10);
			if(i != 12)t.setPriority(Thread.MIN_PRIORITY);//작업우선도를 최대로 낮춤
			else t.setPriority(Thread.MIN_PRIORITY);//작업우선도를 최대로 높임
			t.start();//cpu의 작동방식을 이해할 수 없기 때문에 12개의 쓰레드에 우선도를 부여해도
			//누가 먼저 작동될지 예측 안되고 매번 바뀐다.
		}
	}
}

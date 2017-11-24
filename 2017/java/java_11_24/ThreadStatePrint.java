package java_11_24;

public class ThreadStatePrint {

	public static void main(String[] args) {
		StatePrint sp = new StatePrint(new TestThread());
		sp.start();
	}

}

class TestThread extends Thread{
	public void run() {
		for(long i=0; i<333333333; i++) {}
		
		try {
			Thread.sleep(1333);
		} catch(Exception e) {}
		
		for(long i=0; i<333333333; i++) {}
	}
}

class StatePrint extends Thread {	
	private Thread thread;

	public StatePrint(Thread thread) {
		this.thread = thread;
	}

	public void run() {
		while(true) {
			//targetThread.getState() : 쓰레드의 상태를 반환
			Thread.State state = thread.getState();
			System.out.println("현재 쓰레드의 상태 : " + state);
			if(state == Thread.State.NEW) {//클래스.열거형.열거형상수
				thread.start();
			}
			if(state == Thread.State.TERMINATED) {
				break;
			}
			try {
				Thread.sleep(333);
			} catch(Exception e) {}
		}
	}
}
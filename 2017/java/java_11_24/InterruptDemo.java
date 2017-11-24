package java_11_24;

public class InterruptDemo {

	public static void main(String[] args) {
		Thread it = new InterruptTest();
		it.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("에러발생");
		}
		it.interrupt();
		//Thread.currentThread().interrupt(); 메인에서 인터럽트를 사용할 때
		//현재 참조중인 쓰레드를 받아와 인터럽트를 건다.
		//우리가 흔히 운영체제에서 사용하는 인터럽트와는 다르다. 쓰레드 끼리 제어를 위해 사용
	}

}

class InterruptTest extends Thread{
	@Override
	public void run() {		
		while(true) {
			System.out.println("실행중...");
			if(Thread.interrupted()) break;			
		}
		System.out.println("종료");
	}
}
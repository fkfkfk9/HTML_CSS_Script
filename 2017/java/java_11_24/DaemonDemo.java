package java_11_24;

public class DaemonDemo {

	public static void main(String[] args) {
		Thread dt = new DaemonTest();
		dt.setDaemon(true);//설정은 스타트 이전에 해줘야 된다. 데몬쓰레드 설정
		dt.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("에러발생");
		}
		System.out.println("메인스레드 종료");
		//데몬쓰레드를 설정한다면 메인이 끝날때 데몬쓰레드로 지정된 쓰레드도 같이 종료된다.
		//사용 예로는 문서프로그램이 종료될 경우 자동저장을 들 수 있다.		
	}

}

class DaemonTest extends Thread{
	@Override
	public void run() {		
		while(true) {
			try {
				Thread.sleep(333);
			} catch (InterruptedException e) {
				System.out.println("에러발생");
			}
			System.out.println("실행중...");				
		}
	}
}
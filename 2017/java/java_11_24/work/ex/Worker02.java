package java_11_24.work.ex;

public class Worker02 implements Runnable {

	@Override
	public void run() {
		Thread.currentThread().setName("Work02");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(50);//스테틱 메소드로 사용하여 sleep처리
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//----END TRY-CATCH----
			System.out.println("Worker02 : " + Thread.currentThread().getName());
			//Thread스테틱 메소드로 현재 실행중인 쓰레드의 정보를 받아오는 currentThread를 사용
			//그안의 getName을 통해 쓰레드 이름을 받아온다.
		}//----END FOR----
	}//----END RUN----

}

package java_11_24.work.ex;

public class Worker01 extends Thread {
	public Worker01(String setName) {
		setName(setName);
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep(10);
				//쓰래드를 상속받았기 때문에 스테틱 메소드가 아닌 그냥 sleep로만 실행가능
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//----END TRY-CATCH----
			System.out.println("Worker01 : " + getName());
			//마찬가지로 getName을 그냥 불러올 수 있다.
		}//----END FOR----
	}//----END RUN----
}

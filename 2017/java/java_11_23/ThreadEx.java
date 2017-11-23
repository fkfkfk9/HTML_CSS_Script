package java_11_23;

public class ThreadEx extends Thread {
	public ThreadEx() {
		// TODO Auto-generated constructor stub
	}
	public ThreadEx(String str) {
		setName(str);
	}
	@Override
	public void run() {
		try {
			sleep(3333);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//쓰레드의 우선순위를 확인하기 위해
		//시간 끌기용
		System.out.println(getName() + " 은 쓰레드의 이름");
	}
	
}

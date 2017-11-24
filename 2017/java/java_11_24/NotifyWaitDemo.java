package java_11_24;

public class NotifyWaitDemo {

	public static void main(String[] args) {
		NotifyWaitSrc nws = new NotifyWaitSrc();

		NotifyWaitTest1 nft1 = new NotifyWaitTest1(nws);
		NotifyWaitTest2 nft2 = new NotifyWaitTest2(nws);

		nft1.start();
		nft2.start();
	}

}
//NotifyWait은 synchronized안에서 사용해야 한다.
//쓰레드 클래스의 포함된게 아니라 오브젝트 클래스에 포함되어 있다.
//Wait은 현재 작업을 멈추고 Notify는 이를 공지해 다른쪽으로 자원이 돌아가게 만든다.
//아래 소스는 Notify Wait을 서로 사용해 한번의 작업씩을 번갈아 가면서 하게된다.
class NotifyWaitSrc{
	public synchronized void methodA() {
		System.out.println("Test1의 methodA() 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e){}
	}

	public synchronized void methodB() {
		System.out.println("Test2의 methodB() 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e){}
	}
}
class NotifyWaitTest1 extends Thread{
	private NotifyWaitSrc nws;

	public NotifyWaitTest1(NotifyWaitSrc nws) {
		this.nws = nws;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			nws.methodA();
		}
	}
}
class NotifyWaitTest2 extends Thread{
	private NotifyWaitSrc nws;

	public NotifyWaitTest2(NotifyWaitSrc nws) {
		this.nws = nws;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			nws.methodB();
		}
	}
}
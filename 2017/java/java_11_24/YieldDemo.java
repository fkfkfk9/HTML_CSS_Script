package java_11_24;

public class YieldDemo {

	public static void main(String[] args) {
		YieldTest1 yt1 = new YieldTest1();
		YieldTest2 yt2 = new YieldTest2();	
		yt1.start();		
		yt2.start();
		
		try { 
			Thread.sleep(3000); 
		} catch (InterruptedException e){}
		System.out.println("---- Test2 Yield START ----");
		yt2.work = false;
		
		try {
			Thread.sleep(3000); 
		} catch (InterruptedException e){}
		System.out.println("---- Test2 Yield END ----");
		yt2.work = true;		
		try { 
			Thread.sleep(3000); 
		} catch (InterruptedException e){}
		yt1.stop = true;
		yt2.stop = true;
	}

}

class YieldTest1 extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(333);
			} catch (InterruptedException e){}
			if(work)System.out.println("Test1 Work Work");
			else Thread.yield();
			//Thread.yield() : cpu가 실행하는 시간을 다른 스레드에게 양보
		}
		System.out.println("Test1 End");
	};
}
class YieldTest2 extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(333);
			} catch (InterruptedException e){}
			if(work)System.out.println("Test2 Work Work");
			else Thread.yield();
		}
		System.out.println("Test2 End");
	};
}
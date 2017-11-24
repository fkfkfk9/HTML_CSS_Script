package java_11_24;

import java.util.Map;
import java.util.Set;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		ThreadGroupTest tgt = new ThreadGroupTest();
		tgt.setDaemon(true);
		tgt.setName("GroupTest Thread");
		tgt.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("에러발생");
		}
		//Thread.getAllStackTraces();현재 실행중인 응용프로그램의 스레드 정보를 참조
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for(Thread thread : threads) {
			System.out.println("Name: " + thread.getName() + ((thread.isDaemon())?"(데몬)": "(주)"));
			System.out.println("\t" + "소속그룹: " + thread.getThreadGroup().getName());
			System.out.println();
		}
	}

}

class ThreadGroupTest extends Thread{
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

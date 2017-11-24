package java_11_24;

public class SynchItem {
	private int shared;//공유되는 변수
	//게터엔 셋터
	public int getshared() {
		return shared;
	}

	public synchronized void setshared(int shared) {//공유데이터를 사용함으로
		this.shared = shared;//synchronized를 넣어 임계영역을 만들어 준다.
		try {//객체가 메소드에 접근하면 블락킹이 되어 끝날때까지 접근 불가
			Thread.sleep(2000);
		} catch(InterruptedException e) {}	
		System.out.println(Thread.currentThread().getName() + ": " +  this.shared);		
	}
}

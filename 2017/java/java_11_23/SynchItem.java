package java_11_23;

public class SynchItem {
	private int shared;//공유되는 변수
	//게터엔 셋터
	public int getshared() {
		return shared;
	}

	public void setshared(int shared) {
		this.shared = shared;
		try {
			Thread.sleep(2000);//값을 넣은 후 2초간 잠김 cpu의 우선순위가 넘어감
		} catch(InterruptedException e) {}	
		System.out.println(Thread.currentThread().getName() + ": " +  this.shared);
		//공유자원의 값을 넣어주고 2초간 잠든 후 공유자원값 출력
		//2초간 넘어간 우선순위 때문에 원하는값 출력이 힘듬
	}
}

package java_11_24;


public class SynchEx2 extends Thread{
private SynchItem item;
	
	public void setSynchEx2(SynchItem item) {
		this.setName("Ex2");
		this.item = item;
	}
	
	public void run() {
		item.setshared(8);//입력받은 주소값의 공유자원 값을 8로 바꾼다.
	}
}

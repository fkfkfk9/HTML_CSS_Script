package java_11_23;



public class SynchEx1 extends Thread{
	private SynchItem item;

	public void setCalculator(SynchItem item) {
		this.setName("Ex1");//쓰레드 이름을 바꿔준다. 구분하기 위함
		this.item = item;//입력받은 매개변수의 주소값을 넣어줌
	}

	public void run() {
		item.setshared(13);//입력받은 주소값의 공유자원 값을 13으로 바꾼다.
	}
}

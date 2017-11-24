package java_11_24;

public class NotifyWaitDemo2 {

	public static void main(String[] args) {
		NotifyWaitSrc2 nwf2 = new NotifyWaitSrc2();

		NotifyWaitTestA testA = new NotifyWaitTestA(nwf2);
		NotifyWaitTestB testB = new NotifyWaitTestB(nwf2);

		testA.start();
		testB.start();
	}

}
class NotifyWaitSrc2{
	private String data;

	public synchronized String getData() {
		if(this.data == null) {//공유자원인 data가 값이 존재하는지 판단.
			try {
				wait();//존재하는 값이 없다면 세터의 노티파이를 기다린다.
			} catch(InterruptedException e) {}
		}
		String getValue = data;//데이터가 있다면 넣어줌
		System.out.println("TestB가 읽은 데이터: " + getValue);//데이터 출력
		data = null;//다시 초기화 시켜줌
		notify();//데이터 사용을 다시 공지
		return getValue;//입력받은 데이터를 메소드를 실행한곳에 리턴해줌
	}

	public synchronized void setData(String data) {
		if(this.data != null) {//데이터에 내용이 잇는지 판단 게터가 마무리 됬다면 null로 초기화됨
			try {
				wait();//데이터가 초기화 되어 공지(notify) 되기까지 대기
			} catch(InterruptedException e) {}
		}
		this.data = data;//매개변수 데이터를 공유변수 데이터에 넣어준다.
		System.out.println("TestA가 생성한 데이터: " + this.data);
		notify();//데이터 삽입을 공지
	}
}
class NotifyWaitTestA extends Thread{//데이터 생산 메소드 매개변수로 받아온 객체에
	//set메소드를 사용하여 공유변수에 값을 넣어줌
	private NotifyWaitSrc2 nws2;

	public NotifyWaitTestA(NotifyWaitSrc2 nws2) {
		this.nws2 = nws2;
	}

	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			String data = "Data-" + i;
			nws2.setData(data);
		}
	}
}
class NotifyWaitTestB extends Thread{//데이터 사용 메소드 공유 데이터를 받아와 사용
	private NotifyWaitSrc2 nws2;

	public NotifyWaitTestB(NotifyWaitSrc2 nws2) {
		this.nws2 = nws2;
	}

	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			String data = nws2.getData();
			System.out.println("리턴받은 데이터" + data);
			//notify후에 작업되기 때문에 먼저 작업될수도 늦게 작업될수도 있음
		}
	}
}
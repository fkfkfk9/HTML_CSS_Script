package java_11_23;

public class SynchronizedDemo {

	public static void main(String[] args) {
		SynchItem item = new SynchItem();

		SynchEx1 ex1 = new SynchEx1();
		ex1.setCalculator(item);//같은 객체 주소를 사용함으로 데이터를 공유하게됨
		ex1.start();//첫번째 작업 쓰레드 시작

		SynchEx2 ex2 = new SynchEx2();
		ex2.setCalculator(item);//위와 같다.
		ex2.start();//두번째 작업 쓰레드 시작
		//슬립으로 인해 우선순위가 넘어감으로 첫번째 쓰레드는 공유자원의 값이 두번째가 바꾼걸로
		//바뀐채 출력된다.
	}

}

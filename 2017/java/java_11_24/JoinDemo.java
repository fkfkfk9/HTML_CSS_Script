package java_11_24;

public class JoinDemo {

	public static void main(String[] args) {
		int count = 500;
		JoinTest jt = new JoinTest(count);
		jt.start();
		
		try {
			jt.join();//jt의 run()의 실행이 종료 될때까지 메인쓰레드가 대기하고 기다린다.
			//만약 jt의 run부분이 무한루프면 같이 영원히 기다리게 된다.
			//join이 없다면 더하는 작업이 끝나기도 전에 결과가 나올수도 있어서 정확도가 떨어짐
		} catch (Exception e) {}
		
		System.out.println("1부터 " + count + "까지의 합은 : " + jt.sum);
	}

}

class JoinTest extends Thread{
	int sum = 0;
	int count = 0;
	public JoinTest(int count) {
		this.count = count+1;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);//조인이 없으면 1초동안 결과값을 먼저 출력해 값을 구할 수 없음
			//조인을 하면 1초기다렷다 계산까지 끝난후 결과 출력
		} catch (InterruptedException e) {}
		for (int i = 0; i < count; i++)sum+=i;		
	}
}

package java_11_24.work.ex;

public class WorkEx {

	public static void main(String[] args) {
		Thread work01 = new Worker01("Work01");//Worker01쓰래드 생성
		//쓰레드를 상속받은 클래스이기 때문에 구지 Worker01객체를 생성 안해도 된다.
		//다형성을 이용해 그냥 쓰레드로 생성 가능
		Worker02 wk2 = new Worker02();
		//Runnable을 상속 받았기 때문에 객체 생성
		Thread work02 = new Thread(wk2);//new Thread()는 ()안에 Runnable객체가 필요함
		//위에 생성한 객체를 넣어줌
		work01.setDaemon(true);//데몬 설정
		work01.setPriority(Thread.MAX_PRIORITY);//work01우선순위 맥스로 설정
		work02.setPriority(Thread.NORM_PRIORITY);//Worker02 우선순위 보통으로 설정
		work01.start();//생성한 쓰레드 두개 실행
		work02.start();
		for (int i = 0; i < 10; i++) {//for문을 10번 돌림
			try {
				Thread.sleep(50);//0.05초 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("메인 작업 쓰레드 : " + 
					Thread.currentThread().getName());//현재 작업중인 메인쓰레드 출력
		}//----END FOR----
	}//----END MAIN----

}

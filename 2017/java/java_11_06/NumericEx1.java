package java_11_06;

import java.util.*;//Scanner을 사용하기 위한 api 임포트

public class NumericEx1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//scanner객체 생성
		while(true) {
			System.out.println("정수를 하나 입력 하시오. exit를 치면 종료");//입력 안내문
			try {//숫자가 들어올 경우 실행 숫자가 아니면 에러가 나면서 catch문으로 이동
				int num = scan.nextInt();//입력받은걸 int형으로 불러와 대입시켜준다.
				if(num > 0) {//양수일 때 출력
					System.out.println("입력하신 숫자는 양수입니다.");
				}else if(num == 0) {//0일 때 출력
					System.out.println("입력하신 숫자는 0입니다.");
				}else if(num < 0) {//음수일 때 출력
					System.out.println("입력하신 숫자는 음수입니다.");
				}
			} catch (Exception e) {//숫자가 아닌값이 입력될 경우 에러가나서 캐치문으로 이동
				String scanStr = scan.nextLine();//scan객체의 입력받은 값을 받아온다.
				if(scanStr.equalsIgnoreCase("exit")) {
				//exit와 같은 값인지 확인
					System.out.println("프로그램을 종료 합니다.");
					break;
				}
				System.out.println("입력하신건 숫자가 아닙니다.");
				//숫자도 아니고 exit도 아닐경우 출력문
			}
			System.out.println("----------------------------");
		}		
	}
}

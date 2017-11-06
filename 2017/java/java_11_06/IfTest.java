package java_11_06;

import java.util.*;//Scanner을 사용하기 위한 api 임포트

public class IfTest {

	public static void main(String[] args) {
		int  score = 0;
		char grade, opt; //학점변수, +,-변수 정의
		
		Scanner scan = new Scanner(System.in);//scanner객체 생성
		while(true) {//무한루프문 true를 주기 때문에 무조건 반복한다.
			System.out.println("점수를 입력 하세요. exit를 치면 종료");
			try {//숫자가 들어올 경우 실행 숫자가 아니면 에러가 나면서 catch문으로 이동
				score = scan.nextInt();//입력받은걸 int형으로 불러와 대입시켜준다.
				grade = ' ';//grade와 opt는 반복될때마다 초기화 시켜준다.
				opt   = '\0';
				if(score > 100) {//100점을 넘을 경우 컨티뉴로 다음 루프로 이어간다.
					System.out.println("점수는 100을 넘을 수 없습니다.");
					continue;
				}else if (score < 101 && score >= 98 ) {
					grade = 'A';
					opt = '+';
				}else if( score < 98 && score >= 94 )grade='A';
				else if(score < 94 && score >= 90) {
					grade = 'A';
					opt = '-';
				}else if (score < 90 && score >= 88 ) {
					grade = 'B';
					opt = '+';
				}else if( score < 88 && score >= 84 )grade='B';
				else if(score < 84 && score >= 80) {
					grade = 'B';
					opt = '-';
				}else if (score < 80 && score >= 78 ) {
					grade = 'C';
					opt = '+';
				}else if( score < 78 && score >= 74 )grade='C';
				else if(score < 74 && score >= 70) {
					grade = 'C';
					opt = '-';
				}else if (score < 70 && score >= 68 ) {
					grade = 'D';
					opt = '+';
				}else if( score < 68 && score >= 64 )grade='D';
				else if(score < 64 && score >= 60) {
					grade = 'D';
					opt = '-';
				}else grade = 'F';
				
				System.out.printf("당신의 학점은 %c%c입니다.%n", grade, opt);
			} catch (Exception e) {//숫자가 아닌값이 입력될 경우 에러가나서 캐치문으로 이동
				String scanStr = scan.nextLine();//scan객체의 입력받은 값을 받아온다.
				if(scanStr.equalsIgnoreCase("exit")) {
				//exit와 같은 값인지 확인
					System.out.println("프로그램을 종료 합니다.");
					break;//무조건 반복되기때문에 break를 통해서만 나갈 수 있다.
				}
				System.out.println("입력하신건 숫자가 아닙니다.");
				//숫자도 아니고 exit도 아닐경우 출력문
			}
			System.out.println("----------------------------");
		}		
	}
}

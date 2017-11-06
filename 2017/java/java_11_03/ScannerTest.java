package java_11_03;

import java.util.*;    // Scanner를 사용하기 위해 추가

class ScannerTest { 
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);

		System.out.print("데이터를 하나 입력해주세요.");

		String in = scan.nextLine();
		try {
			int num = Integer.parseInt(in); // 입력받은 문자열을 숫자로 변환
			System.out.println("입력내용 :"+in);
			System.out.printf("num=%d%n", num);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("입력내용 :"+in);
		}		
		scan.close();
		
		char ch = ' ';		
		ch = in.charAt(0);

		if('0'<= ch && ch <= '9') {
			System.out.printf("입력하신 문자는 숫자입니다.\n");
		}

		if(('a'<= ch && ch <= 'z') || ('A'<= ch && ch <= 'Z')) {
			System.out.printf("입력하신 문자는 영문자입니다.\n");
		}
	} 
}
package java_11_07;
import java.util.*;

public class WhileEx {

	public static void main(String[] args) {
		/*
			조건식 : 결과코드가 true or false 이어야 한다.
			
			while(조건식){
				문장;
				//조건식 false가 되는 처리를 해주어야 한다.
			}
		*/
		System.out.print("반복 횟수 입력>");
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		int i = 0;
		int count = 0;
		boolean flag = true;
		
		while(flag) {//flag는 자주 사용된다.			
			System.out.print("*");
			if(i == count) {
				i = 0;
				count++;
				System.out.println();
			}
			i++;
			if(count == max) {				
				flag = false;
			}
		}
	}

}

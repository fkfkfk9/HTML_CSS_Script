package java_11_07;
import java.util.*;

public class SwitchEx {

	public static void main(String[] args) {
		/*
		  switch(정수 또는 문자열){
		  	case 값1:
		  		문장;
		  		break;
		  	case 값2:
		  		문장;
		  		break;
		  		...
		  	default:
		  		문장;
		  }
		*/
		
		System.out.print("동물을 입력하시오.> ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		switch(input) {
			case "돼지":
				System.out.println("꿀꿀");
				break;
			case "병아리":
				System.out.println("삐약 삐약");
				break;
			case "소":
				System.out.println("음메");
				break;
			case "오리":
				System.out.println("꽥꽥");
				break;
			default:
				System.out.println("등록되지 않은 동물입니다.");
		}
	}

}

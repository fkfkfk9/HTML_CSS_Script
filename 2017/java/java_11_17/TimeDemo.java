package java_11_17;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeDemo {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now(); //현재 날짜를 구해온다.
		LocalTime lt  = LocalTime.now();  // 현재 시간을 구해온다.

		LocalDate birth = LocalDate.of(1988, 11, 3); 
		LocalTime birthTime = LocalTime.of(7, 33, 13);	

		System.out.println("현재 날짜 : " + ld);
		System.out.println("현재 시간 : " + lt);
		System.out.println("태어난 날짜 : " + birth);   
		System.out.println("태어난 시간" + birthTime);  
			
		//필드(년,월,일,시,분,초,나노초 필드)값 변경 with+@
		System.out.println(birth.withYear(2002));//값자체가 변경되는게 아니라 
		//변경된 값이 리턴된다.	    
	    System.out.println(birth.withDayOfMonth(13));//해당달을 기점으로 일수를 바꾼다.
	    System.out.println(birth.withDayOfYear(32));
	    //해당년을 기준으로 1월부터 숫자만큼 지난 일수를 표시 말일을 넘으면 자동으로 월을 넘김
	    System.out.println(birthTime.withHour(13));
	    System.out.println(birthTime.withMinute(55));
	    
	    //plus(), minus()도 있다 with처럼 +@를 붙여 @값을 바꿈
	    System.out.println(birth.plusDays(5));
	    System.out.println(birth.plus(1,ChronoUnit.MONTHS));
	    
		//ChronoUnit.시간,분,초 뭘 선택하냐에 따라 그 부분까지 출력해준다.
		System.out.println(birthTime.truncatedTo(ChronoUnit.MINUTES)); 			
		// 특정 ChronoField의 범위를 알아내는 방법
		System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range()); // 1-24
		System.out.println(ChronoField.HOUR_OF_DAY.range());       // 0-23
	}

}

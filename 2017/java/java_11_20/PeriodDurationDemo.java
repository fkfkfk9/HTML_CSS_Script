package java_11_20;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDurationDemo {
	/*
		period : 날짜의 차이
		Duration : 시간의 차이
	*/
	
	public static void main(String[] args) {
		LocalDate birDay = LocalDate.of(1988,  11,  03);
		LocalDate entDay = LocalDate.of(2007, 03, 02);

		Period p = Period.between(birDay, entDay);
		
		System.out.println("태어난 날 : " + birDay);
		System.out.println("대학교 입학날 : " + entDay);
		System.out.println("태어나서 대학교 입학까지 ="+ p);
	
		System.out.println("YEAR=" +p.get(ChronoUnit.YEARS)); 
		System.out.println("MONTH="+p.get(ChronoUnit.MONTHS)); 
		System.out.println("DAY="  +p.get(ChronoUnit.DAYS));  

		LocalTime sleep = LocalTime.of( 1, 30, 0); 
		LocalTime wakeUp = LocalTime.of(8,3,33);

		Duration d = Duration.between(sleep, wakeUp);

		System.out.println("잠든 시간 : "+sleep);
		System.out.println("기상 시간 : "+wakeUp);
		System.out.println("수면 시간 : "+d);
		//Period get을 통해 가져올 수 있지만 Duration은 불가능하다.
		//그렇기 때문에 LocalTime의 겟 메서드를 통해 가져온다.
		LocalTime tmpTime = LocalTime.of(0,0).plusSeconds(d.getSeconds());

		System.out.println("HOUR="  +tmpTime.getHour());
		System.out.println("MINUTE="+tmpTime.getMinute());
		System.out.println("SECOND="+tmpTime.getSecond());
		System.out.println("NANO="  +tmpTime.getNano());
	}

}

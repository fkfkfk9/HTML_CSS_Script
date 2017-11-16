package java_11_16;

import java.util.*;

public class CalendarDemo {

	public static void main(String[] args) {//기본적으로 현재 시간을 가져온다.
		Calendar now = Calendar.getInstance();
		//api상 추상클래스이기 때문에 new로 메모리생성 불가 즉 객체생성이 불가능하다.
		//추상클래스는 생성자 메서드를 만들어 줄 수도 있지만 Calendar은 내부생성만 가능하게 되있다.
		System.out.println("현재 시간 기준");
		System.out.println("년도 : " + now.get(Calendar.YEAR));
		System.out.println("월 : " + now.get(Calendar.MONTH));//0부터계산 +1해줘야 한다.
		System.out.println("일 : " + now.get(Calendar.DATE));
		System.out.println("올해의 몇주 : " + now.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이번달의 몇주 : " + now.get(Calendar.WEEK_OF_MONTH));
		
		System.out.println("이번달의 몇일: " + now.get(Calendar.DAY_OF_MONTH));
		System.out.println("올해의 몇일: "		+ now.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일 : " + now.get(Calendar.DAY_OF_WEEK)); 
		// 1:일요일, 2:월요일, ... 7:토요일
		System.out.println("이 달의 몇 째 요일: "	+ now.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("오전_오후: " + now.get(Calendar.AM_PM));
		//(0:오전, 1:오후)
		System.out.println("시간 : "	+ now.get(Calendar.HOUR));//(0~11)
		System.out.println("시간 : "	+ now.get(Calendar.HOUR_OF_DAY));//(0~23)
		System.out.println("분 : "	+ now.get(Calendar.MINUTE));//(0~59)
		System.out.println("초 : "	+ now.get(Calendar.SECOND));//(0~59)
		System.out.println("ms : " + now.get(Calendar.MILLISECOND));
        //(0~999)밀리세컨드 1000분의 1초
		// 천분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.(1시간 = 60 * 60초)
		System.out.println("TimeZone(-12~+12): " + (now.get(Calendar.ZONE_OFFSET)/(60*60*1000))); 
		System.out.println("이번달의 마지막 날: " + now.getActualMaximum(Calendar.DATE) );
		// 이 달의 마지막 일을 찾는다.
	}

}

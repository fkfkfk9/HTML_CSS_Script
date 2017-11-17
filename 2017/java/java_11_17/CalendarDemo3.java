package java_11_17;

import java.util.*;

public class CalendarDemo3 {
	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1}; // 큰 단위를 앞에 놓는다.
		final String[] TIME_UNIT_NAME = {"H ", "MIN ", "SEC "};

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		cal1.set(Calendar.HOUR_OF_DAY, 13);
		cal1.set(Calendar.MINUTE, 13);
		cal1.set(Calendar.SECOND, 13);

		cal2.set(Calendar.HOUR_OF_DAY, 23);
		cal2.set(Calendar.MINUTE, 33);
		cal2.set(Calendar.SECOND, 33);
		
		System.out.println("cal1 :"+cal1.get(Calendar.HOUR_OF_DAY)+"시 " + 
		cal1.get(Calendar.MINUTE) +"분 " + cal1.get(Calendar.SECOND) + "초");
		System.out.println("cal2 :"+cal2.get(Calendar.HOUR_OF_DAY)+"시 " + 
		cal2.get(Calendar.MINUTE) +"분 " + cal2.get(Calendar.SECOND) + "초");
		
		/* 밀리세컨드로 Calendar데이터를 빼주고 그 밀리세컨드를 다시 시간으로 만드는 알고리즘 */
		long dateSub =  Math.abs(cal2.getTimeInMillis() - cal1.getTimeInMillis())/1000;
		System.out.println("cal1과 cal2의 차이는 "+ dateSub +"초 입니다.");

		String temp = "";
		
		for(int i=0; i < TIME_UNIT.length;i++) { 
			temp += dateSub/TIME_UNIT[i]+ TIME_UNIT_NAME[i]; 
			dateSub %= TIME_UNIT[i];
		} 
		
		System.out.println("시분초로 변환하면 " + temp + "입니다.");
		/*-----------------------------------------------------------------*/
	}
}

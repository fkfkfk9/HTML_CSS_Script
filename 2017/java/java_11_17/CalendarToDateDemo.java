package java_11_17;

import java.util.*;

public class CalendarToDateDemo {

	public static void main(String[] args) {
		/* Calendar -> Date 변환 */
		Calendar cal = Calendar.getInstance();
		
		Date d = new Date(cal.getTimeInMillis());
		//ctrl + shift + o를 누르면 import로 인해 오류가 날때 임포트 시키는 단축키
		
		/* Date -> Calendar 변환 */
		Date d2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		
		System.out.println(d);
		System.out.println(cal2.get(Calendar.YEAR) + "." + cal2.get(Calendar.MONTH) 
		+ "." + cal2.get(Calendar.DATE));
	}

}

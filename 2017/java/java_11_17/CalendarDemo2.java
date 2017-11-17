package java_11_17;

import java.util.Calendar;

public class CalendarDemo2 {

	public static void main(String[] args) {
		//요일은 1부터 시작하기 때문에 인덱스 0은 비워두기 위해 널값을 넣는다.
		final String[] dayOfTheWeek = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.set(1988, Calendar.NOVEMBER, 3);
		//(1988, 10, 3)으로 할수도 있다. 11월이 10인 이유는 0부터 시작이기 때문
		System.out.println("나의 생일은 " + toString(cal1) + " " 
		+ dayOfTheWeek[cal1.get(Calendar.DAY_OF_WEEK)] + "요일 입니다.");
		//Calendar.DAY_OF_WEEK의 리턴값 때문에 dayOfTheWeek배열의 0번째를 널로 채웠다.
		//Calendar.DAY_OF_WEEK값이 배열의 인덱스가 되어 요일을 찾아 출력한다.
		System.out.println("현재 날짜는 " + toString(cal2) + " " 
				+ dayOfTheWeek[cal2.get(Calendar.DAY_OF_WEEK)] + "요일 입니다.");
		
		long dateSub = (cal2.getTimeInMillis()-cal1.getTimeInMillis())/1000;
		//ms 즉 밀리세컨드이기 때문에 초를 구하려면 1000을 나눠줘야 한다.
		System.out.println("내가 태어나고 " + dateSub + "초가 지났습니다.");
		System.out.println("일수로는 " + dateSub/(60*60*24) + "일이 지났습니다.");
		//초를 일로 나눠준다.
		
		//비슷한 기능으로 roll메서드가 있는대 add메서드의 경우 일필드가 말일을 넘으면
		//자동으로 월을 +1 시키고 진행되지만 roll필드는 다른 필드에 영향이 없다.
		//roll이 유일하게 다른필드에 영향을 받는건 말일이 다른경우가 있기 때문에
		//일이 말일로 설정되어있을때 달이 바뀌면 일도 따라서 바뀐다.
		cal2.add(Calendar.YEAR, -10);//add메서드를 통해 앞에 바꾸고싶은 변수를 놓고
		cal2.add(Calendar.MONTH, -9);//뒤에 음수나 양수로 날짜를 더하거나 빼면서 설정가능
		cal2.add(Calendar.DATE, 13);
		System.out.println("대학교 입학 날짜 : " + toString(cal2));
	}
	public static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR)+"-"+ (cal.get(Calendar.MONTH)+1) +"-" + cal.get(Calendar.DATE);
	}
}

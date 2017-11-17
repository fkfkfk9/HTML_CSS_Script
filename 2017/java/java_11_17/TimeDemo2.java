package java_11_17;

import java.time.*;

public class TimeDemo2 {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now(); //현재 날짜를 구해온다.
		LocalTime lt  = LocalTime.now();  // 현재 시간을 구해온다.
		LocalDate ld2 = LocalDate.of(2007, 03, 02);
		LocalTime lt2  = LocalTime.of(9, 50, 33);
		
		/*로칼데이터 타입을 정의하는 여러방법들*/
		LocalDateTime ldt = LocalDateTime.of(ld, lt);//날짜와 시간을 한번에 
		LocalDateTime ldt2 = LocalDateTime.of(1988,11,3,13,33,33);
		LocalDateTime ldt3 = ld2.atTime(lt2);
//		LocalDateTime ldt3 = lt2.atDate(ld2);
//		LocalDateTime ldt3 = ld2.atTime(12, 24, 56);
//		LocalDateTime ldt3 = lt2.atDate(2011,3,13);
//		LocalDateTime ldt3 = lt2.atDate(LocalDate.of(2011,3,13));
//		LocalDateTime ldt3 = ld2.atStartOfDay();
//		LocalDateTime ldt3 = LocalDateTime.now();
		//역으로 시간 날짜 정보를 추출해서 각자 넣어줄수도 있음
		LocalDate ld3 = ldt2.toLocalDate();
		LocalTime lt3 = ldt3.toLocalTime();
		
		//Zone : 각 국가의 도시별 시간정보를 참조하기위한 영역개념
		//LocalDateTime클래스를 이용하여 ZonedDateTime클래스 객체 생성
//		1)존id객체 생성
		ZoneId zi = ZoneId.of("Asia/Seoul");
		ZoneId zi2 = ZoneId.of("America/New_York");
//		2)ZonedDateTime Zone 날짜시간 정보객체 생성 zid사용하여 생성한다.
		ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(zi2);
		ZonedDateTime seoulTime = ZonedDateTime.now().withZoneSameInstant(zi);		
		ZonedDateTime zdt2 = ldt2.atZone(zi2);
		//ldt2저장된 시간에 zi2뉴욕 시간대를  + 시켜 특정 시간에 해당 지역표시를 해준다.
		OffsetDateTime odt = zdt2.toOffsetDateTime();
		//뉴욕 정도만 없애고 표준시간대에서 -5라는견 표기시켜줌
		
		System.out.println(zdt2);//특정시간에 + 뉴욕 포멧 붙여줌
		System.out.println(nyTime);//실제 뉴욕 현재시간에 + 뉴욕 포멧을 붙여줌
		System.out.println(seoulTime);//현재 서울 시간에 + 서울 포멧
		System.out.println(odt);//특정시간에 표준시간대 표시해주고 포멧은 없앰
	}

}

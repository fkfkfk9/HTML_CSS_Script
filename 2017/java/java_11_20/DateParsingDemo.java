package java_11_20;

import java.time.*;
import java.time.format.DateTimeFormatter;
public class DateParsingDemo {

	public static void main(String[] args) {
		//파싱(Parsing) : 어떤 정보를 사용하고자 하는 타입 또는 포맷으로 변환하는 기능
		LocalDate birDay = LocalDate.parse("1988-11-03", 
				DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate ld = LocalDate.parse("2002-06-01");
		LocalTime lt = LocalTime.parse("18:33:13");
		LocalDateTime ldt = LocalDateTime.parse("2002-06-01T18:33:13");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime endOfYear = LocalDateTime.parse("2017-12-31 23:59:59", dtf);
		
		System.out.println(birDay);
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		System.out.println(endOfYear);
	}

}

package java_11_17;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		SimpleDateFormat sdf1, sdf2;
		Date d = new Date();
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 a");
		System.out.println(sdf1.format(d));
		System.out.println(sdf2.format(d));
		//더 많은 표현법이 있다. SimpleDateFormat표를 참조
		
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
				
		try {
			Date d1 = df.parse("1988년 11월 3일");
			//위에 선언한 심플포멧안의 내용대로 데이트 값을 입력가능
			System.out.println(df2.format(d1));		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

}

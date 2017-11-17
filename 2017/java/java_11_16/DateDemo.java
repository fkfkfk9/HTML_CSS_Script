package java_11_16;
import java.util.*;

public class DateDemo {

	public static void main(String[] args) {
		Date now = new Date();//권장하지 않음
		//오래되서 사용을 권장하지 않을정도지만 과거 프로그램 유지보수할 때 필요하다.
		System.out.println(now);
		
		Date bir = new Date(1988, 11, 3);//이렇게 입력할 경우 제대로 출력안됨
		System.out.println(bir);
		bir.setYear(1988);
		bir.setMonth(11);
		bir.setDate(3);
		System.out.println(bir.getYear() + "년 " + bir.getMonth() + "월 " +
		bir.getDate() + "일");
	}

}

package java_11_17;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersDemo {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		
		System.out.println(today);
		System.out.println(today.with(TemporalAdjusters.firstDayOfNextMonth()));
		//다음달 첫날
		System.out.println(today.with(TemporalAdjusters.firstDayOfNextYear()));
		//다음해 첫날
	}

}

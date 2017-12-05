package java_12_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DualStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("박지성", "손흥민", "권창훈", "이승우", "석현준");
		
		Stream<String> st = list.stream();
		st.forEach(DualStream::pntString);//메서드 참조방식
		//DualStream에서 만든 스테틱 pntString 메서드 사용
		//메인쓰레드로만 작업한다.
		System.out.println();
		
		//병렬처리 듀얼코어를 이용할때 사용한다.
		Stream<String> parast = list.parallelStream();
		parast.forEach(DualStream::pntString);
		//쓰레드를 여러개 이용하여 각자 처리시킨다.
	}
	public static void pntString(String str) {
		System.out.println(str + "을 진행한 스레드 - "
							+ Thread.currentThread().getName());
	}
}

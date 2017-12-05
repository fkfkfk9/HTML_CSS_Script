package java_12_04;

import java.util.Arrays;
import java.util.List;

public class FilteringDemo {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("박지성", "손흥민", "차범근", "이영표", "박지성");
		
		//1단계 - 참조변수.stream(); stream객체 생성하는 방법
		//2단계 - 중간처리 distinct() 동일한 요소가 있다면 제거해준다.
		list.stream().distinct().forEach(System.out::println);
		System.out.println();
		//filter()은 내부에 predicate()함수적 인터페이스를 람다로 정의해줘야함
		//startsWith는 스트링 클래스
		//filter, distinct는 중간처리 기능으로 두개를 전부 사용할수도 있다.
		list.stream().filter(t->t.startsWith("박")).forEach(System.out::println);
	}
}

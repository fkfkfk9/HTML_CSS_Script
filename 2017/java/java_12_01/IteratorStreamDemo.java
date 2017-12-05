package java_12_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorStreamDemo {

	public static void main(String[] args) {
		//1)구문
		List<String> list = Arrays.asList("박지성", "손흥민", "권창훈");
		
//		list.add("이승우");에러가 나지는 않지만 실행해보면 안됨 이유는 asList로 추가하는 순간
		//list의 내부에 사이즈가 고정이 되어 3개이상의 데이터를 넣을 수 없다.
		
		//2)구문
		List<String> aList = new ArrayList<>();
		aList.add("박지성");aList.add("손흥민");aList.add("권창훈");
		
		//기존의 Iterator사용
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String FootballPlayer = it.next();
			System.out.println(FootballPlayer);
		}
		
		//stream방식 : 줄이 훨씬 줄어든다 람다식을 사용한다.
		Stream<String> st = list.stream();
		st.forEach(System.out::println);
		//stream의 forEach은 함수형 인터페이스인 Consumer을 요구하기 때문에 람다식 사용가능
	}

}

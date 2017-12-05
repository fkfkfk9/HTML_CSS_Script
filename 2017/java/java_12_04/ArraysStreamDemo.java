package java_12_04;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysStreamDemo {

	public static void main(String[] args) {
		int[] arr = {3,7,8,13,33,38};
		
		//Arrays클래스 : 배열에 기능을 지원하기위한 목적으로 만들어짐
		//Collections 클래스 : 컬레겻넹 기능을 지원하기위한 목적으로 만들어짐
		
		IntStream is = Arrays.stream(arr);
		//켈렉션에선 스트림을 바로 사용가능하지만 배열은 .을 찍어도 스트림이 나오지 않는다.
		//이런경우 스트림을 만들고 대입값을 Arrays클래스를 사용하여 스트림화해서 넣어준다.
		is.asDoubleStream().forEach(System.out::println);
		//인트형 스트림을 더블형 스트림으로 리턴해옴
		System.out.println();
		
		is = Arrays.stream(arr);
		is.boxed().forEach(t->System.out.println(t.intValue()));
		//boxed는 일반 값타입을 레퍼런스타입으로 바꿈 예)int->Integer
	}

}

package java_12_04;

import java.util.Arrays;
import java.util.List;

public class FlatMapDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("17/12/04", "17/11/03");
		list.stream().flatMap(date -> Arrays.stream(date.split("/")))
		.forEach(System.out::println);
	}

}

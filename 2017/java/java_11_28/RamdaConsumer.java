package java_11_28;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class RamdaConsumer {

	public static void main(String[] args) {
		Consumer<int[]> con = t-> System.out.println(Arrays.toString(t));
		//Consumer<T>는 함수형 인터페이스이다. 람다식으로 익명함수를 만들어 사용한다.
		//Consumer의 특징은 매개변수는 있는대 리턴타입은 없는것이다.
		con.accept(new int[]{1,2,3,4,5});
		//BiConsumer는 Consumer에서 매개변수만 늘어난것
		BiConsumer<Integer, Integer> bc = (t,u)->System.out.println(t + 
				"와 " + u + "의 합은 " + (t+u) + "이다.");
		bc.accept(33, 88);
		
	}

}

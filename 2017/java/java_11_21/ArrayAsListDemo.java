package java_11_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAsListDemo {

	public static void main(String[] args) {
		int[] arr = {3, 8, 13};
		List list = Arrays.asList(new Integer[] {1,2,3,4,5});
		List list2 = Arrays.asList(arr);
		System.out.println(list);
		System.out.println(list2);//배열의 주소값만 들어갔지 배열자체를 리스트로는 못바꿈
		
		//list.add(6);//실행시 에러가 난다. 이유는 배열을 넣어서 만들면 크기가 배열만큼 고정된다.
		//즉 추가 삭제는 불가능 값의 수정은 가능하다.
		List list3 = new ArrayList(Arrays.asList(1,2,3,4,5));//이런식으로 선언하면 크기가 고정안된다.
		list3.add(6);
		System.out.println(list3);
	}

}

package java_11_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ArrayListDemo2 {

	public static void main(String[] args) {
		int cut = 5;
		String str = "15947qwera가나다라마!@#$%";
		int length = str.length();
		
		//ArrayList list = new ArrayList(length/cut+5)로 할수도 있다.
		//List인터페이스에서의 추상메서드를 사용하고, ArrayList클래스를 변경할 경우 편리
		List list = new ArrayList(length/cut+5);//메모리 사이즈에 여유를 둔다.
		for (int i = 0; i < length; i+=cut) {
			if(i+cut < length)
				list.add(str.substring(i, i+cut));
			else
				list.add(str.substring(i));//i부터 마지막까지
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

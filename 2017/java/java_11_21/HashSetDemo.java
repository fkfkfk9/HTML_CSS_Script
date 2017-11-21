package java_11_21;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		Object[] arr = {"3", new Integer(13), "박지성", "A", "3", "박지성", "A"};
		//부모의 인터페이스로 참조변수 생성
		//인터페이스로 정의를 하는 이유는 재사용성 때문 인터페이스를 상속받은 다른 기능으로
		//바뀔 경우 정의할 생성자만 바꿔주면 된다. 때문에 해당 변수로 사용하는 메소드가
		//인터페이스에 존재하는 추상 메소드라면 구지 상속받은 클래스로 생성하기보단 인터페이스를 사용
		//Set 인터페이스 : 저장순서는 유지하지 않고  중복된 값은 허용하지 않는다.
		Set s = new HashSet();
		
		for (int i = 0; i < arr.length; i++) {
			s.add(arr[i]);//리턴형이 불리언 즉 펄스값이 넘어올때는 데이터 추가가 안됨			
		}
		System.out.println(s);//결과상 중복값은 들어가지 않앗다.
		//값 또한 들어간 순서대로 나오는게 아니라 알수 없는 순서로 출력된다.
		//여기서 중복값은 주소로 만약에 참조변수를 new를 통해 새 메모리에 만든다면 값이 같더라도
		//주소값이 다르므로 해쉬셋에 저장이 가능하다.
		Set s2 = new HashSet();
		s2.add(new Integer(13));s2.add(new Integer(3));s2.add(new Integer(8));
		s2.add(new Integer(1));s2.add(new Integer(33));s2.add(new Integer(7));
		System.out.println(s2);
		List l = new LinkedList(s2);//부모가 같은 컬렌션인 리스트와 셋의 관계이기 때문에 가능
				
		//숫자들을 오름차순으로 만들기 위해 sort를 해준다.
		Collections.sort(l);
		System.out.println(l);
	}

}

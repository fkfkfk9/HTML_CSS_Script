package java_11_21;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		//Map인터페이스 구현
		//키와 값의 구조로 데이터를 관리한다.
		//키는 유일해야하고 값은 중복이 가능하다.
		HashMap map = new HashMap<>();
		map.put("한국", "수원");
		map.put("영국", "런던");
		map.put("일본", "도쿄");
		map.put("한국", "서울");//Key가 중복된다.
		//에러가 나지 않는대신 마지막 값이 덮어서 처음값은 날라간다.
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("나라를 입력하면 수도 표시");
			System.out.print("나라를 입력 : ");
			String contry = scan.nextLine().trim();//공백을 없에기 위해		

			if(!map.containsKey(contry)) {
				System.out.println("해당국가는 데이터에 없습니다. \n 다시 검색해주세요.");
				continue;
			}else {
				System.out.println("수도는 " + map.get(contry) + "입니다.");
				break;
			}
		}//while문 끝
		Set s = map.entrySet();
		//entrySet메서드를 사용하여 맵을 셋으로 바꿀 수 있다. 키+값의 형태로 셋에 넣어준다.
		Iterator it = s.iterator();//셋을 순차적으로 접근하기 위해 Iterator이용
		while(it.hasNext()) {//더이상 Iterator에 읽을 값이 없을때까지 루프
			//Map은 내부적으로 Entry인터페이스를 정의해놓았다. 키와 값을 관리해준다.
			Map.Entry me = (Map.Entry)it.next();
			//Map.Entry이용하여 키값과 벨류값을 나누어 버린다.
			System.out.println("나라 : " + me.getKey() + ", 수도 : " + me.getValue());
			//그냥 출력해주면 키와 값이 출력되는대 따로 출력가능
		}
		s = map.keySet();//키만 가져올수도 있다.
		System.out.println(s);
		Collection c = map.values();//값만 가져올수도 있다. values의 리턴타입이 컬렉션이라
		it = c.iterator();//컬렉션 변수를 만들어 받아온다.
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}//main 끝

}

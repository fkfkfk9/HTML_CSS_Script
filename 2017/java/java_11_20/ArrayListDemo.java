package java_11_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


public class ArrayListDemo {

	public static void main(String[] args) {
		/*
			ArrayList 객체를 생성하는 형태
			1)ArrayList al = new ArrayList();
			2)1)ArrayList al = new ArrayList(10); 기억장소의 크기를 넣음
		*/
		ArrayList arr = new ArrayList();
		arr.add(new Integer(55));
		arr.add(new Integer(8));
		arr.add(new Integer(33));
		arr.add(new Integer(13));		
		
		ArrayList arr2 = new ArrayList(arr.subList(0, 3));
		//subList를 사용시 가저올 리스트의 (시작점, 끝점) 시작~끝바로전까지 즉 시작이상 끝미만
		System.out.println("arr  : " + arr);
		System.out.println("arr2 : " + arr2);
		Collections.sort(arr);
		arr2.sort(Comparator.naturalOrder());
		System.out.println("sort작업 후");
		System.out.println("arr  : " + arr);
		System.out.println("arr2 : " + arr2);		
		System.out.println("arr2가 arr에 포함되는가 : " + arr.containsAll(arr2));
		//arr2의 컬렉션요소가 arr의 켈렉션에 모두 존재하는지 유무 체크
		arr2.add(1, "Add");//앞에 숫자를 넣으면 해당인덱스 자리에 데이터를 넣는다.
		//나머지 데이터는 한칸씩 밀린다.
		System.out.println("데이터 추가 후 arr2 : " + arr2);
		arr2.set(1, "update");
		System.out.println("데이터 수정 후 arr2 : " + arr2);
		//두 리스트에서 겹치지 않는 데이터만 삭제.
		System.out.println("arr에서 arr2와 겹치지 않는 데이터 삭제 : " + arr.retainAll(arr2));
		System.out.println("arr  : " + arr);
		//arr2에서 arr에 포함된 객체들을 삭제한다.
		//arr2.size()는 리스트의 들어가있는 객체수
		//뒤에서 부터 삭제하는건 앞에서 부터 삭제하면 모든객체 인덱스를 땡겨와야 되서 비효율
		for (int i = arr2.size()-1;i>=0; i--) {
			if(arr.contains(arr2.get(i))) {
				arr2.remove(i);
			}
		}
		System.out.println("arr과 겹치는걸 삭제한 arr2  : " + arr2);
	}

}

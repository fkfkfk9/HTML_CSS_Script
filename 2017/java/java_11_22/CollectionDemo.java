package java_11_22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class CollectionDemo {

	public static void main(String[] args) {
		List al = new ArrayList();
		System.out.println(al);
		
		Collections.addAll(al, 3, 7, 8, 13, 33, 88);
		System.out.println("After addAll : " + al);
		
		Collections.rotate(al, 3);
		System.out.println("After rotate 3 : " + al);
		//rotate는 리스트 안의 데이터를 매개변수로 넣어준 int데이터만큼 오른쪽으로 이동
		//뒤에 있던 숫자들은 앞으로 온다.
		Collections.swap(al, 1, 3);
		System.out.println("After swap 1,3 : " + al);
		//리스트상의 데이터들을 교환해준다 (리스트명, 바꿀데이터 인덱스, 바꿀데이터 인덱스)
		Collections.shuffle(al);
		System.out.println("After shuffle : " + al);
		//리스트의 데이터들을 랜덤하게 썩어준다.
		Collections.sort(al);
		System.out.println("After shuffle : " + al);
		//오름차순으로 정렬해준다.
		Collections.sort(al, Collections.reverseOrder());
		System.out.println("After shuffle + reverseOrder : " + al);
		//내림차순으로 정렬해준다.
		System.out.println("Index of 33 : " + Collections.binarySearch(al, 33));
		System.out.println("List of maxNum : " + Collections.max(al));
		System.out.println("List of minNum : " + Collections.min(al));
		System.out.println("List of minNum : " + 
				Collections.max(al, Collections.reverseOrder()));
		Collections.fill(al, 38);
		System.out.println("After fill : " + al);
		//매개변수로 받은 데이터로 리스트의 모든 장소의 값을 바꾼다.
		List copylist = Collections.nCopies(al.size(), 8);
		//(리스트의 크기, 값)크기를 정하고 넣어준 매개변수 값으로 채운다 크기만 카피되는것이다.
		System.out.println("After nCopies 8 : " + copylist);
		System.out.println("al과 copylist가 같은 데이터가 없는가 ? " + 
						Collections.disjoint(al, copylist));//같은 데이터가 없다면 true
		Collections.copy(al, copylist);//뒤에 넣어준 리스트의 데이터를 앞에 리스트에 넣어줌
		//copylist와 al의 순서를 바꾸면 안되는 이유는 copylist의 사이즈를 고정 시켯기 때문에
		//복사기능이 되지 않는다. 마찬가지로 add같은 경우도 오류가 난다.
		System.out.println("After copy al : " + al);
		System.out.println("After copy copylist : " + copylist);
		ArrayList alCopy = new ArrayList();
		for(int i = 0; i<6; i++)alCopy.add(i);//copy를 하기 위해선 사이즈를 맞춰줘야된다.
		Collections.copy(alCopy, al);//즉 작은 사이즈의 리스트에 큰리스트는 복사가 안된다.
		System.out.println(alCopy);//반대로 큰 사이즈의 리스트는 작은 리스트 복사가 된다.
		
		Collections.replaceAll(al, 8, 13);
		System.out.println("After replaceAll 8 13 : " + al);
		//(리스트명, 바꿀값, 바뀔값) 가운데값 모두를 3번째 값으로 바꿈
		Enumeration e = Collections.enumeration(al);
		ArrayList al2 = Collections.list(e);
		System.out.println(al2);//리스트를 복사
	}

}

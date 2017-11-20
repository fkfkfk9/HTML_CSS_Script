package java_11_20;
import java.util.*;

class IteratorDemo {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("박지성");
		al.add("차범근");
		al.add("손흥민");
		al.add("차두리");
		al.add("이영표");

		//컬랙션의 요소에 접근하는 데 사용하는 인터페이스
		Iterator it = al.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		//Iterator의 경우 맨앞의 데이터를 다시 참조하려면 객체를 새로 생성해야한다.
		it = al.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		//거꾸로 될돌아가는 기능이 없기 때문 
		System.out.println("ListIterator");
		//Iterator를 가장 많이 사용 했었지만 최신기능은 ListIterator이다.
		//Iterator보다 기능이 더 많다. 되돌아가는 기능도 있기때문에 재사용성도 뛰어남
		ListIterator li = al.listIterator();

		while(li.hasNext()) {
			System.out.print(li.next() + "|");//순방향으로 진행
		}
		System.out.println();
		//뒤에서 부터 앞으로 순차적으로 검색
		while(li.hasPrevious()) {
			System.out.print(li.previous() + "|");//역방향으로 진행
		}
		System.out.println();
	}
}

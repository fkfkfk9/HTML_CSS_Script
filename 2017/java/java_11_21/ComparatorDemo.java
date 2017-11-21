package java_11_21;
import java.util.*;

class ComparatorDemo {
	public static void main(String[] args) {
		String[] sArr = {"박지성", "손흥민", "차범근", "루니"};
		//Comparable를 구현하는 클래스들은 기본정렬로 처리되어있다.
		//기본정렬(오름차순) : 공백-숫자-대문자-소문자 순으로(즉 유니코드순으로 정렬)
		System.out.println("처음 sArr=" + Arrays.toString(sArr));
		Arrays.sort(sArr); 
		System.out.println("소트 후 sArr=" + Arrays.toString(sArr));

		Arrays.sort(sArr, String.CASE_INSENSITIVE_ORDER);//대소문자 무시 비교
		//한글로 했기 때문에 차이 없음 영어로 할 경우 대소문자 유니코드의 차이 때문에 
		//알파벳 순에 상관없이 정렬되므로 이 경우 사용된다.
		System.out.println("sArr=" + Arrays.toString(sArr));

		Arrays.sort(sArr, new Descending()); 
		System.out.println("sArr=" + Arrays.toString(sArr));
	}
}
//클래스 설계를 해서 사용자 정의 정렬을 사용하고자 할때 참조
class Descending implements Comparator { 
	public int compare(Object o1, Object o2){
		if( o1 instanceof Comparable && o2 instanceof Comparable) {
			//입력받은 객체가 sort가 가능한지 즉 Comparable을 상속 받았는지 확인함
			//자바안에서 정렬이 필요한 모든 클래스들은 Comparable을 상속 받는다.
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1 ;//음수를 곱해서 역순을 만든다.
			//두객체를 비교할때 앞쪽이 크면 양수 같으면 0 작으면 음수							   
		}
		return -1;
	} 
} 

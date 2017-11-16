package java_11_16;

public class StringBufferEx {
	/*
		StringBuffer과 StringBuilder은 거의 동일하지만 쓰레드 때문에 나뉘어져있다.
		String클래스는 인스턴스를 생성할 때 문자열을 변경할 수 없지만 
		StringBuffer는 가능하며 크기지정도 가능
		String는 메소드 작업이든 더하는 연산이든 조작을 해도 변경되는것이 아니라
		메모리에 새로운 경로를 만들어 그 위치에 또 만드는 방식이라 메모리 낭비가 심하다.
		StringBuffer는 한번 만든 메모리를 가지고 조작하면서 같은곳을 사용한다.
		StringBuffer가 멀티쓰레드의 동기화할때 성능이 떨어지기 때문에
		StringBuffer에서 쓰레드의 동기화만 뺀 StringBuilder가 새로추가되었다.
		즉 멀티 쓰래드를 사용할때는 StringBuffer 싱글쓰레드에선 StringBuilder를 사용
	*/
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("fkfkfk9");
		StringBuffer sb2 = new StringBuffer("fkfkfk9");
	
		System.out.println("sb == sb2 : " + (sb == sb2));
		System.out.println("sb equals sb2 : " + sb.equals(sb2));
		//StringBuffer의 equals는 오브젝트 클래스 그대로 주소값을 비교 값비교가 안된다.
		String str = sb.toString();//toString를 이용해 String로 바꿀 수 있다.
		
		sb.delete(0, sb.length());
		sb2.delete(0, sb.length());//지우는 메서드(시작지점, 끝나는지점)
		
		sb.append("abc");
		sb2 = sb.append("def");
		StringBuffer sb3 = sb.append("ghi.");
		
		System.out.println("sb :  " + sb);
		System.out.println("sb2 : " + sb2);
		System.out.println("sb3 : " + sb3);//대입시켯기 때문에 3개의 값은 같다.
		//같은 주소값을 가지기 때문 다르게 만들려면 new를 이용해야 한다.
		System.out.println("deleteCharat(9) 9번째 하나지움 : " +  sb.deleteCharAt(9));
		//인덱스 위치를 지움
		System.out.println("insert(시작인덱스,추가할 문자열)문자열추가 : " + sb.insert(9, "jkl"));
		//인덱스부터 데이터 추가
		System.out.println("replace(시작인덱스, 끝인덱스, 지우고 넣을 문자열)문자열수정 : " +
							sb.replace(1, sb.length(), "pple"));
		System.out.println("capacity(버퍼 크기) : " + sb.capacity());
		System.out.println("length(문자열 길이) : " + sb.length());
	}
}

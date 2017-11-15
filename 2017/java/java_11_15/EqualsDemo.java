package java_11_15;

public class EqualsDemo {

	public static void main(String[] args) {
		EqualsTest et1 = new EqualsTest();
		EqualsTest et2 = new EqualsTest();
		
		//equals는 두 객체가 같은건지 비교를 한다.
		//언뜻보면 같은 클래스로 만든 객체라 같은거라 생각하지만 여기서 equals는
		//생성된 두객체를 비교하는대 객체는 주소값을 보관하므로 서로다른 주소값을 보관하는
		//et1과 et2는 다르다는 결과가 나온다.
		if(et1.equals(et2)) System.out.println("두 객체는 같습니다.");
		else System.out.println("두 객체는 다릅니다.");
	}

}

class EqualsTest{}
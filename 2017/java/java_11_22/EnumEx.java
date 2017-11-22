package java_11_22;

enum Direction {//사용자 정의 데이터 타입 클래스 밖에 쓴다.
	EAST(1), WEST(2), SOUTH(3), NORTH(4);
	private final int value;
	Direction(int value){this.value = value;}
	public int getValue() {return value;}
}
//열거형 멤버는 모두 final static상수
class EnumDemo{
	int a;

	//사용자 정의 열거형 데이터 타입
		
	public int getA() {
		return a;
	}

	public void setA(int a) {
		if(a < 1 || a > 4) {//겟터와 셋터를 이용해 값에 제한을 줄 수 있다.
			return;
		}		
		this.a = a;
	}
}
public class EnumEx {
	
	
	public static void main(String[] args) {
		int a;//1,2,3,4(1:동쪽, 2:서쪽, 3:남쪽, 4북쪽 4가지 값만 넣고 싶을 때)
		
		EnumDemo ed = new EnumDemo();
		ed.setA(5);//값이 넘어가면 기본값 0
		System.out.println(ed.getA());
		Direction d = Direction.WEST;
		System.out.println(d);
		System.out.println(d.getValue());
		
	}

}

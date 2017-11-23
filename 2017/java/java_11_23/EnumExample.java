package java_11_23;

public class EnumExample {

	public static void main(String[] args) {
		Direction d = Direction.EAST;//열거형 변수 d는 객체와 같은 의미이다.
		//Direction d = new Direction(EAST);와 비슷하다고 생각하면 된다.
		System.out.println("name() : " + d.name());
		System.out.println("ordinal() : " + d.ordinal());
		System.out.println("getValue() : " + d.getValue());
		Direction d2 = Direction.NORTH;
		System.out.println("name() : " + d2.name());
		System.out.println("ordinal() : " + d2.ordinal());
		System.out.println("getValue() : " + d2.getValue());
		//ordinal는 기본으로 주어지는 값으로 상수를 정의한 순서대로 값이 들어간다.
		//getValue는 내가 입력해준 값이 들어간다.
		d2.methodA();//객체로도 사용할 수 있고
		Direction.EAST.methodA();//스테틱메소드처럼 사용가능
	}

}
enum Direction{
	//상수명의 값을 수동으로 지정해서 사용하는 경우에는 요구조건이 있다.
	//지정한 값을 저장하기위한 필드가 선언되어 있어야 하고 생성자를 통해 값을 줘야한다.
	EAST(1){void methodA(){System.out.println(name() + getValue());}},
	//상수명 안에서 추상메서드를 각각 상수에 맞게 정의해준다.
	SOUTH(5){void methodA(){System.out.println(name() + getValue());}},
	WEST(-3){void methodA(){System.out.println(name() + getValue());}},
	NORTH(13){void methodA(){System.out.println(name() + getValue());}};
	//constructor(생성자)를 의미 생성자가 없어서 오류가나기 때문에 생성자를 만들어준다.
	private final int value;
	private Direction(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	//추상 메서드는 재정의를 열거형 상수병에서 재정의 해야 한다.
	abstract void methodA();
}

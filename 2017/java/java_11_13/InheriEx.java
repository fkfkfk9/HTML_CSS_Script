package java_11_13;

public class InheriEx {

	public static void main(String[] args) {
		Circle c = new Circle();
		Circle2 c2 = new Circle2();
		
		c2.c.x = 10;
		c2.c.y = 20;
		c2.r = 5;
		
		c.x = 20;
		c.y = 40;
		c.r = 10;
		//상속을 사용하든 포함관계를 사용하든 결과값을 내는대는 문제가 없다.
	}

}
//클래스의 관계에서 상속 또는 포함관계 어떤걸 쓸것인지 선택하여 사용해야 한다.
//프로그래밍적으로 구분하지는 않고 의미적으로 포함관계인지 실제로 비슷한 개념인지를 생각하고 결정
//즉 ~은 ~이다는 상속, ~은 ~을 가지고있다 는 포함관계
class Point{
	int x;
	int y;
}
//단일상속 : extends 오른쪽에 오는 상속받을 클래스는 1개만 가능하다.
//만약 하나 이상의 클래스를 상속시키고 싶다면 상속을 1개하고 다른 클래스를 포함시켜 사용한다.
class Circle extends Point{
	int r;
}

class Circle2{//상속을 하지 않아도 상속한것처럼 쓸 수 있다.
	Point c = new Point();
	int r;
}
/*
	object Class : 자바 API의 최상위 클래스
	구성요소 : 필드는 없고, 메서드는 있다.
	
	메서드의 공통적인 특징 : 
	자바언어의 큰 특징과 관계된 개념적인 메서드의 성격을 가지고있다.
*/

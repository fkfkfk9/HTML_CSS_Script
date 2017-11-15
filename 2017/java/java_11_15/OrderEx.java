package java_11_15;

public class OrderEx {

	public static void main(String[] args) {
		Order o1 = new Order();
		Order o2 = o1.deepCopy();//깊은복사
		Order o3 = (Order)o1.clone();//얕은복사
		o1.x = 300;
		o1.y = 400;
		o1.name = "박찬호";
		o1.p.a = 333;
		o1.p.b = 888;
		System.out.println("o1객체 데이터");
		System.out.println(o1.toString());
		System.out.println("o2객체 데이터");
		System.out.println(o2.toString());
		System.out.println("o3객체 데이터");
		System.out.println(o3.toString());
		//밑에처럼 다 출력해도 되지만 toString()를 오버라이딩 해서 출력해줘도 된다.
		/*System.out.printf("o1.x = %d, o1.y = %d, o1.name = %s, o1.p.a = %d, o1.p.b = %d\n"
				, o1.x, o1.y, o1.name, o1.p.a, o1.p.b);
		System.out.printf("o2.x = %d, o2.y = %d, o2.name = %s, o2.p.a = %d, o2.p.b = %d\n"
				, o2.x, o2.y, o2.name, o2.p.a, o2.p.b);
		System.out.printf("o3.x = %d, o3.y = %d, o3.name = %s, o3.p.a = %d, o3.p.b = %d\n"
				, o3.x, o3.y, o3.name, o3.p.a, o3.p.b);*/
		//객체주소까지 복사되어 o1만 바꿧는대 o3.p까지 변경됨
	}

}

class Order implements Cloneable{
	int x;
	int y;
	String name;
	Point p;
	Order(){
		this.x = 100;
		this.y = 200;
		this.name = "홍길동";
		this.p = new Point();
	}
	Order(int x, int y, String name, int a, int b){
		this.x = x;
		this.y = y;
		this.name = name;
		this.p = new Point(a, b);		
	}
	public String toString() {
		return String.format("x = %d, y = %d, name = %s, p.a = %d, p.b = %d\n"
				, x, y, name, p.a, p.b);
	}
	
	public Object clone() {//얕은복사
		Object obj = null;
		try {
			obj = super.clone();
		} catch (Exception e) {}
		return obj;
	}
	public Order deepCopy(){//깊은복사
		Object obj = null;
		try {
			obj = super.clone();
		} catch (Exception e) {}
		Order o = (Order)obj;
		o.p = new Point(20, 30);
		return o;
	}
}

class Point{
	int a, b;
	Point(){
		a = 10;
		b = 20;
	}	
	Point(int a, int b){
		this.a = a;
		this.b = b;
	}
}

package java_11_22;

public class GenericMethod {

	public static void main(String[] args) {
		Car<Integer> c1 = Management.washing(100);
		int iv = c1.getT();
		System.out.println(iv);
		Car<String> c2 = Management.washing("유종현");
		String sv = c2.getT();
		System.out.println(sv);
		//제네릭 메서드를 호출시 메서드의 파라미터에 제공하는 값의 타입을 보고
		//유추해서 <T>타입의 값을 결정하게된다.
	}

}

class Car<T>{
	private T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}	
}

class Management{
	/*
		public static Car washing(매개변수){
			Car c = new Car();
			return c;
		}
	*/
	//washing메서드가 호출시 파라미너틔 제공하는 값의 타입을 보고
	//컴파일러 유추를 해서 <T>에 타입을 대입을 하게된다.
	//예> washing(100); 컴파일러가 100의 값의 타입을 유추해서
	//Integer를 T타입 파라미터로 결정하게 된다.
	public static <T> Car <T> washing(T t){
		//static뒤에 <T>오는 이유는 오지 않으면 에러가 난다.
		//원칙적으로 스텍틱에는 타입이 정해지지 않은 <T>가 올 수 없는대 미리 제네릭형인걸 알려줌으로써
		//사용가능하게 된다 제네릭 클레스에서 클래스명 뒤에 <T>를 붙이는 이유와 같다.
		//즉 제네릭 메소드라는걸 표기해주기 위해 <T>를 적어준다.
		Car<T> c = new Car<T>();
		c.setT(t);
		return c;
	}
}
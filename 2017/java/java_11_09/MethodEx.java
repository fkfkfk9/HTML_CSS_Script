package java_11_09;

public class MethodEx {

	public static void main(String[] args) {
		MethodTest method = new MethodTest();
		
		String name = method.nickName();//리턴타입과 맞는 타입의 변수에 넣어줘야한다.
		
		System.out.println(name);
		System.out.println(method.nickName());//결과가 같다.
		
		method.add(10, 20);//add안의 매개변수도 형을 맞춰줘야 한다.
	}

}

class MethodTest{
	
	public String nickName() {
		return "네파리안";
	}
	public int add(int a, int b) {
		return a+b;
	}
}

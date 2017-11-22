package java_11_22;

public class DataTest {

	public static void main(String[] args) {
		Data<String, Integer> d = new Data<String, Integer>();
		//String를 <>사이에 넣는순간 클래스 안의 <T>를 넣은 변수들이 String이 된다.
		d.iv = 33;
		d.sv = "abc";
		System.out.println(d.iv + " : " + d.sv);
		//jdk1.7
		Data<String, Integer> d2 = new Data<>();//뒤의 <>는 생략가능
	}

}

package java_11_08;

class Product {
	int a;
	int b;
	
	//메서드 : 함수와 비슷하다
	int add() {
		return a+b;
	}
}

public class IntroClass{
	public static void main(String[] args) {
		Product product = new Product();
		product.a = 10;
		product.b = 20;
		System.out.println(product.add());
	}
}
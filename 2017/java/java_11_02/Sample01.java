package java_11_02;

public class Sample01 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.printf("a + b 의 결과는 ? %d \n", a+b);
		System.out.printf("a - b 의 결과는 ? %d \n", a-b);
		System.out.printf("a * b 의 결과는 ? %d \n", a*b);
		System.out.printf("a / b 의 결과는 ? %1.1f \n", (float)a/b);
		//0.5000000이 나오므로  1자리만 나오게 1.1로 설정 
		//그냥 나누면 정수형으로 나누어 지므로 소수로 형변환해준뒤 넣어줌
		System.out.println("-----------println------------");
		System.out.println("a + b 의 결과는 ? " + (a+b));
		System.out.println("a - b 의 결과는 ? " + (a-b));
		System.out.println("a * b 의 결과는 ? " + (a*b));
		System.out.println("a / b 의 결과는 ? " + ((double)a/(double)b));
	}
}

package java_11_06;

public class AndOrOper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 8, num2 = 13;
		
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		//앞의 num1>5가 true가 되면 뒤의 값의 결과에 상관없이 무조건 true이기 때문에
		//||뒤의 연산은 실행되지 않는다 즉 ++b 연산자체가 되지 않는다.
		//만약 앞의 연산이 false였다면 b값은 증가했을것이다.
		System.out.println("num1 > 5 || ++num2 < 15 : " + (num1 > 5 || ++num2 < 15));
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		//앞의 num1>10는 false가 된다 엔드연산은 앞의값이 펄스면 뒤의 연산을 하지 않는다.
		//즉 앞의값이 펄스기 때문에 증가연산이 실행되지 않았다.
		System.out.println("num1 > 10 && ++num2 < 15 : " + (num1 > 10 && ++num2 < 15));
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
	}

}

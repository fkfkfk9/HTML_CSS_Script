package java_11_06;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Yoo";//원시변수 스타일
		String str2 = new String("Yoo");//레퍼런스 스타일
		//new : 메모리 생성연산자.
		
		System.out.printf("13 == 13.0f   %b\n", 13==13.0f);
		//형변환이 먼저 일어난 후 비교 되기 때문에 true
		System.out.printf("'8'== 8       %b\n", '0'== 0);
		//숫자 8은 8이고 문자 8은 아스키코드값이기 때문에 서로 다르다.
		System.out.printf("'\\0'== 0     %b\n", '\0'== 0);
		//\0과 숫자0은 결과값이 같게 설계되어 있다. 0은 NULL을 의미한다.
		System.out.printf("'F'== 70      %b\n", 'F'== 70);
		//F의 아스키 코드 값은 70이다.
		System.out.printf("'F' > 'G'     %b\n", 'F' > 'G');
		//G가 F보다 크다.
		System.out.printf("'F'+1 != 'G'  %b\n", 'F'+1 != 'G');
		//F+1은 G가 맞다.
		System.out.printf("0.1==0.1f    %b\n",  0.3==0.3f);
		//정수 부분만 있을때는 더블과 플롯이 같지만 소수부분은 다르다.
		System.out.printf("str1 은 str2와 같은가 : %b\n", str1==str2);
		//두 데이터는 주소값이 다르다. 하나는 레퍼런스 성격이고 하나는 값 성격이다.
		System.out.printf("Yoo 은 Yoo와 같은가 : %b\n", "Yoo"=="Yoo");
		//한번 Yoo를 사용하면 다음에 Yoo를 사용할때 메모리상에 Yoo가 있는지 찾아보고 참조한다.
		System.out.printf("str1 은 Yoo와 같은가 : %b\n", str1=="Yoo");
		//위의 Yoo와 Yoo의 비교 처럼 이미 Yoo주소값이 있기때문에 메모리상의 Yoo를 재사용해서 같다.
		System.out.printf("str1 은 Yoo와 같은가 : %b\n", str2=="Yoo");
		//str2는 주소값을 가지고 있기때문에 문자와 직접비교를 해도 펄스가 난다.
		System.out.println("str2 은 Yoo와 같은가 : " + str2.equals("Yoo"));
		//때문에 직접 값을 비교하는게 아니라 문자열 값을 비교해주는 equals메소드를 사용하여 비교
		System.out.println("str2 은 Yoo와 같은가 : " + str2.equals("YOO"));
		//대문자와는 비교가 안된다.
		System.out.println("str2 은 Yoo와 같은가 : " + str2.equalsIgnoreCase("YOO"));
//		equalsIgnoreCase 메소드를 사용하면 대소문자 상관없이 문자만 비교해준다.
		//즉 ==은 주소값을(객체비교) 비교해주고 equals는 값만 비교한다.
	}

}

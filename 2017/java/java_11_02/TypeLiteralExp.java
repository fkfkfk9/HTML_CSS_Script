package java_11_02;

public class TypeLiteralExp {

	public static void main(String[] args) {
		int oct = 013;//8진법 표현할때는 숫자 0을 앞에넣어줌
		int hex = 0x13;//16진법 표현은 숫자0과 x를 붙인다.
		int bin = 0b1011;//2진법은 숫자0과 b를 붙인다. 2진법인 1과 0만이용해야 한다.
		
		long big = 133_333_333_333L;//_는 L을 안쓰면 오류 long형에서 사용
		long hex_l = 0x0AAA_BBBB_CCCC_DDDDL;		
		//float pi = 3.14;소수는 디폴트로 맨위에 d가 붙기때문에 작은 float는 f를 안붙히면 에러
		double db1 = 13.;
		double db2 = .13;
		float fl = 13f;
		double db3 = 1e3;
		double db4 = 1e-3;
		
		int i = 'A';
		String str = "";//길이가 0인 문자열(공백)
		//char ch = '';에러가 난다 1개의 문자가 들어가야한다.
		char ch2 = ' ';//공백이라도 1개가 들어가서 에러가 없음
	
		System.out.println("8진법 13 : " + oct);//11
		System.out.println("16진법 13 : " + hex);//19
		System.out.println("2진법 1011 : " + bin);//11
		System.out.println("long 데이터 : " + big);//133333333333
		System.out.println("long 16진법 데이터 : " + hex_l);//768633101689347549
		System.out.println("더블형 13. : " + db1);//13.0
		System.out.println("더블형 .13 : " + db2);//0.13
		System.out.println("플롯형 13f : " + fl);//13.0
		System.out.println("더블형 1e3 : " + db3);//1000.0
		System.out.println("더블형 1e-3 : " + db4);//0.001
		System.out.println("인트형 A : " + i);//65
	}

}

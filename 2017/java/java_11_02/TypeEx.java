package java_11_02;

public class TypeEx {

	public static void main(String[] args) {
		//	논리형 데이터 타입
		boolean bol1 = true;
		boolean bol2 = false;
		
		//문자 데이터 타입 문자의 값을 유니코드의 숫자값으로 저장 0~65535
		char ch1 = '유';//char형은 문자포멧으로 값은 ''사이에 넣고 1개만 가능
		char ch2 = '박';

		//		문자열 데이터 타입
		String str1 = "유종현";//문자열은 문자 여러개가 들어가지고 ""사이에 넣는다.
		String str2 = "박지성";
		
		//정수형 데이터 타입
		byte bt = 50; //1byte(-128~127)
		short sh = 100;//2byte
		int it = 200;//4byte(기본)
		long ln = 500L;//8byte
		//일반적인 정수형 데이터는 4byte고 그냥사용하지만 
		//롱형 데이터는 L을 붙이면 8byte가 된다. 구지 사용하지 않는다.
		
		//실수형 데이터 타입
		float fl = 10.5f;//4byte
		double db = 10.5d;//8byte(기본)D는 생략하고 써도 된다.
		//더블이 더 크기 때문에 더블에는 f도 사용 가능하다.
		if(bol1) {
			System.out.println(ch1 + str1 + bt + sh + fl);
		}
		if(bol2 == false) {
			System.out.println(ch2 + str2 + it + ln + db);
		}
	}

}

package java_11_06;

public class LongOper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inum1 = 1000000;    
		int inum2 = 2000000;  

		long lnum1 = inum1 * inum2;//곱하면 오버플로우가 일어남
		//롱형 데이터에 대입하기도 전에 인트형끼리 연산에서 오버플로우가 일어난다.
		System.out.println(lnum1);
		
		lnum1 = 1000000 * 1000000;//인트형 숫자 드개라 오버플로우
		long lnum2 = 1000000 * 1000000L;//L을 붙여 형변환이 일어나 롱형이 된다.

		System.out.println("lnum1 = " + lnum1);
		System.out.println("lnum2 = " + lnum2);
	}

}

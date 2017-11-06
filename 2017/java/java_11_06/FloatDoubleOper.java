package java_11_06;

public class FloatDoubleOper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float pi = 3.1415f; 
		float piTwo = (int)(pi * 1000) / 1000f;
		//int로 변화되면서 소수점 뒷자리를 버리면서 소수를 자른다. 

		System.out.printf("%4.3f \n", pi);//printf를 통해 자를 수 있음
		System.out.println(piTwo);
		
		piTwo = (int)(pi * 1000 + 0.5) / 1000f;//반올림 하고싶을 때
		System.out.println(piTwo);
		piTwo = Math.round(pi * 1000 + 0.5) / 1000f;//반올림 구하는 함수
		System.out.println(piTwo);
		
		int inum1 = 8;
		int inum2 = 13;

		System.out.printf("%d을 %d로 나누면, \n", inum1, inum2); 
		System.out.printf("%d이고, 나머지는 %d입니다.\n", inum1 / inum2, inum1 % inum2);
		System.out.printf("%d을 %d로 나누면, \n", inum1, inum2); 
		System.out.printf("%f 입니다.\n", inum1 / (double)inum2);
		//형변환하면 int값으로는 나오지 않던 나누기의 정확한 값이 나온다.
		//나머지 결과의 부호는 왼쪽 값의 부호와 같게 연산된다.
		System.out.println(-13%8);
		System.out.println(13%-8);
		System.out.println(-13%-8);
	}

}

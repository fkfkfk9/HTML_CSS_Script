package java_11_08;

public class JaggedArrayEx {

	public static void main(String[] args) {
		//JaggedArray는 가변배열을 말한다.
		//가변 배열은 다차원 배열에서 행마다 사이즈를 다르게 하는걸 말한다.
		
		int[][] jArr = new int[3][];//뒤에 인덱스를 생략한다.
		jArr[0] = new int[3];//각각 첫 인덱스마다 사이즈를 다르게 선언함
		jArr[1] = new int[5];
		jArr[2] = new int[2];
		
		for (int i = 0; i < jArr.length; i++) {
			for (int j = 0; j < jArr[i].length; j++) {
				jArr[i][j] = (i*j)+(int)(Math.random()*10);
			}			
		}
		int sum = 0;
		for (int[] is : jArr) {
			for (int i : is) {
				sum += i;
			}
		}
		System.out.println("모든 배열의 합은 : " + sum);
		
		for (int i = 0; i < jArr.length; i++) {
			for (int j = 0; j < jArr[i].length; j++) {
				System.out.printf("jArr[%d][%d] = %d \n", i, j, jArr[i][j]);
			}			
		}
	}

}

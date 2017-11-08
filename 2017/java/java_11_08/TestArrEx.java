package java_11_08;

public class TestArrEx {

	public static void main(String[] args) {
		int[][][] testArr = {
				{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
				{{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
				{{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}
		};
		
		testArr[1][1][1] = 140;
		
		for (int i = 0; i < testArr.length; i++) {
			for (int j = 0; j < testArr[i].length; j++) {
				for (int k = 0; k < testArr[i][j].length; k++) {
					System.out.printf("testArr[%d][%d][%d] - %d\n", 
							i, j, k, testArr[i][j][k]);
				}
			}		
		}		
	}
}

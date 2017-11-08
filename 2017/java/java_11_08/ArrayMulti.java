package java_11_08;
import java.util.*;

public class ArrayMulti {

	public static void main(String[] args) {
		/*
			1차원 배열
			int[] arr = new int[3]
			2차원 배열
			int[][] arr = new int[3][2] 테이블,행렬
			3차원 배열
			int[][][] arr = new int[3][2][3] 큐브형태
		*/
		//int[][] arr2 = new int[][] {{3, 6, 9},{13, 33, 8}};
		int[][] arr2 = {//new int[][]생략 가능
				{3, 6, 9},
				{13, 33, 8},
				{7, 22, 88}
		};
		//2차원 배열 출력
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.println("arr2[" + i + "]" + "[" + j + "] = " +
						arr2[i][j] );
			}		
		}
		int sum = 0;
		for (int[] temp : arr2) {
			for (int i : temp) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}

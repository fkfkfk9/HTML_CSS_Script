package java_11_20;

import java.util.Arrays;

public class ArraysDemo {
	public static void main(String[] args) {
		int[]	arr   =  {3,7,8,13,22};
		int[][] arr_d =  {{33,37,38}, {83,87,88}};

		System.out.println("arr="+Arrays.toString(arr));
		System.out.println("arr2="+Arrays.deepToString(arr_d));
		//2차원 배열은 toString를 할 시 2차원 배열들의 각각 주소값 배열이 리턴된다.
		//실제 값을 보려면 deepToString을 넣어 줘야한다.

		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOf(arr, 3);//복사할 배열과 배열 사이즈를 정한다.          
		int[] arr4 = Arrays.copyOf(arr, 8);          
		int[] arr5 = Arrays.copyOfRange(arr, 1, 3);  
		int[] arr6 = Arrays.copyOfRange(arr, 0, 8);  

		System.out.println("arr2=" + Arrays.toString(arr2));
		System.out.println("arr3=" + Arrays.toString(arr3));
		System.out.println("arr4=" + Arrays.toString(arr4));
		System.out.println("arr5=" + Arrays.toString(arr5));
		System.out.println("arr6=" + Arrays.toString(arr6));

		int[] arr7 =  new int[3];
		Arrays.fill(arr7, 8);//배열의 값을 모두 한가지 값으로 채움
		System.out.println("arr7=" + Arrays.toString(arr7));

		Arrays.setAll(arr7, i -> (int)(Math.random()*13)+1);
		//특정 값으로 채워 넣을 수도있다.
		System.out.println("arr7="+Arrays.toString(arr7));

		for(int i : arr7) {
			char[] graph = new char[i];
			Arrays.fill(graph, '*');
			System.out.println(new String(graph)+i);
		}

		String[][] str_d  = new String[][]{{"abc","def"},{"ABC","DEF"}};
		String[][] str_d2 = new String[][]{{"abc","def"},{"ABC","DEF"}};

		System.out.println(Arrays.equals(str_d, str_d2));//주소값 비교가 되어 펄스
		System.out.println(Arrays.deepEquals(str_d, str_d2));
		//2차원 배열이기 때문에 단순 비교는 주소값 비교가 되버린다. deepEquals을 하면 값비교

		char[] chArr = { 'A', 'D', 'C', 'B', 'E' };

		int index = Arrays.binarySearch(chArr, 'B');
		System.out.println("chArr="+Arrays.toString(chArr));
		System.out.println("index of B ="+Arrays.binarySearch(chArr, 'B'));
		System.out.println("= After sorting =");
		Arrays.sort(chArr);
		System.out.println("chArr="+Arrays.toString(chArr));
		System.out.println("index of B ="+Arrays.binarySearch(chArr, 'B'));
	}
}

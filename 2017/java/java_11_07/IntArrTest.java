package java_11_07;

public class IntArrTest {
	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for(int i = 0; i<arr.length ; i++)		{
			arr[i] = i*2;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}	
}

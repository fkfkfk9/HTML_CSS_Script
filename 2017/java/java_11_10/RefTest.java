package java_11_10;
import java.util.*;

public class RefTest {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		System.out.println("arrMethod 실행 전");
		System.out.println(Arrays.toString(arr));
		
		arrMethod(arr);
		
		System.out.println("arrMethod 실행 후");
		System.out.println(Arrays.toString(arr));
		
		RefTest rt = new RefTest();
		//static이 없는 메소드를 쓰위 위해선 객체를 선언해야함
		System.out.println(rt.add(arr[1], arr[2]));
		//리턴 타입이 필요한 메소드엔 값을 넘겨도 상관없다.
		rt.add(arr);
		//void타입의 메소드라면 객체를 보내야 실제 값이 변경된다.
		System.out.println(Arrays.toString(arr));
	}
	
	static void arrMethod(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 100*(i+1);
		}
	}
	//클래스 안에 동일한 메서드가 중복 될 수 없다(프로그래밍 이론)
	//인스턴스 메서드 static가 없다.
	int add(int num1, int num2) {
		return num1 + num2;
	}
	void add(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			arr[arr.length-1] += arr[i];
		}
	}
}

package java_11_07;
import java.util.*;

public class ArrayEx {

	public static void main(String[] args) {
		/*
			int[] arr = new int[5];
			데이터 타입[] 변수명(객체) = new 데이터 타입[첨자];
			데이터 타입 변수명[] = new 데이터 타입[첨자]; 두가지는 같다.
			첨자 = 배열의 크기
			new = 메모리 생성 연산자 
			배열은 값을 저장하는게 아니라 주소를 저장하는대 주소를 저장하는 기억장소는
			4바이트의 크기로 생성된다.
			int[] arr; 배열선언
			arr = new int[]{10,20,30,40,50};배열 생성
		*/
		Scanner scan = new Scanner(System.in);
		
		System.out.print("더할 숫자의 갯수를 설정해 주세요.>");
		int arr_size = scan.nextInt();
		
		int[] arr = new int[arr_size];
		int sum = 0;
		
		System.out.println("숫자를 " + arr_size + "번 입력하시오.");
		
		/*
			배열의 길이 : length
			속성 명령어는 1)읽기만 가능 2)읽기, 쓰기 둘다 가능
			arr.length = 13; 이 코드는 오류가 난다. 쓰기 불가능
		*/
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			sum += arr[i];
		}		
		char[] ch_arr = {'a', 'b', 'c', 'd', 'e'};
		System.out.println("입력하신 숫자의 합은 : " + sum);
		System.out.println(Arrays.toString(arr));
		//Arrays.toString은 java.util을 임포트 해야하며 배열상 모든 데이터를 출력해준다.
		System.out.println(arr);
		//println은 int형 배열은 지원하지 않는다. 여기서 출력하는건 객체로 배열의 주소를 출력해준다.
		System.out.println(arr.hashCode());
		//우리가 실제 주소를 볼 수 없다 위에 arr만 이용한거보다 정확한 객체주소를 출력해준다.
		System.out.println(ch_arr);		
		//println은 char형 배열은 지원한다. 배열에 있는 모든 내용을 연결해서 출력해준다.
	}

}

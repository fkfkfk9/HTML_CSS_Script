package java_11_08;
import java.util.*;

public class ArrayCopy {
	public static void main(String[] args) {
		/* 정수형 배열 선언 */
		int[] iArr = new int[7];
		
		/* for문을 짝수로 입력해준다.  */
		for (int i = 0; i < iArr.length; i++) iArr[i] = i*2;
		
		/* 현재까지 입력된 배열 출력 */
		System.out.println("****** 복사 전 ******");
		System.out.println("iArr배열의 갯수 : " + iArr.length);
		System.out.println(Arrays.toString(iArr));
		
		/* 배열 복사 시작 */
		int[] copyArr = new int[iArr.length+8];//기존보다 사이즈를 늘린 배열선언
		for (int i = 0; i < iArr.length; i++) 
			copyArr[i] = iArr[i];//선언된 배열에 기존의 데이터 복사
		iArr = copyArr;//기존의 객체에서 새로운 객체로 접근주소를 변경한다.
		
		/* 배열 복사 후 배열 출력 */
		System.out.println("****** 복사 후 ******");
		System.out.println("iArr배열의 갯수 : " + iArr.length);
		System.out.println(Arrays.toString(iArr));
		
		/* ArrayCopy메소드를 이용한 복사 */
		int[] copyArr2 = new int[iArr.length-2];
		System.arraycopy(iArr, 0, copyArr2, 0, copyArr2.length);
		/*arraycopy안의 내용은 iArr[0]에서 copyArr2[0] 으로 
		  copyArr2.length만큼 복사하라는 뜻*/
		iArr = copyArr2;
		
		/* ArrayCopy 동작 후 배열 출력 */
		System.out.println("****** ArrayCopy ******");
		System.out.println("iArr배열의 갯수 : " + iArr.length);
		System.out.println(Arrays.toString(iArr));
	}
}

package java_11_08;
import java.util.*;

public class BubbleSort {

	public static void main(String[] args) {
		/* 객체 선언 */
		Scanner scan = new Scanner(System.in);
		Bubble bu = new Bubble();
		/* 배열 정의 */
		System.out.println("정렬할 배열의 사이즈를 정해주세요.");
		bu.setArrSize(scan.nextInt());
		bu.setiArr();
		bu.arrInRan();
		bu.arrPrint();
		bu.arrBuSort();
	}
}

/* 버블 소트 클래스 */
class Bubble{
	/* 정의부 */
	//캡슐화를 위해 private로 선언
	private int arrSize = 0;//배열 사이즈를 위한 정수
	private int temp = 0;//소트중 숫자 교환용으로 사용
	private int[] iArr;
	private boolean check = false;
		
	/* 배열 정의 */
	public void setiArr() {
		this.iArr = new int[arrSize];
	}
	/* 배열 사이즈 크기 설정 */
	public void setArrSize(int arrSize) {
		this.arrSize = arrSize;
	}
	/* 배열에 랜덤 숫자 넣어주기 */
	public void arrInRan() {
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = (int)(Math.random()*10);//0~9까지 랜덤숫자 발생
		}
	}
	/* 배열 출력 */
	public void arrPrint() {
		System.out.println(Arrays.toString(iArr));//배열 출력
	}
	/* 버블 소트 */
	public void arrBuSort() {		
		for (int i = 0; i < iArr.length-1; i++) {
			check = false;//매번 false로 초기화 해줘야 루프 탈출문이 작동한다.
			//+1과 비교하기 때문에 -1까지만 루프를 돌려도 된다.
			for (int j = 0; j < iArr.length-1-i; j++) {
			//루프를 돌수록 끝에있는 수는 이미 가장 큰수이기 때문에 그 전까지 돌리기 위해 i도 빼줌
				if(iArr[j] > iArr[j+1]) {
					temp = iArr[j];
					iArr[j] = iArr[j+1];
					iArr[j+1] = temp;
					check = true;//더 이상 큰수가 없다면 적용안되서 루프 탈출 용도로 쓰임
				}/* end if */
			}/* end for j */
			if(check == false) break;//더 이상 큰수가 없다면 탈출
			arrPrint();
		}/* end for i */
	}
}

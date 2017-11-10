package java_11_10;

public class VarargsTest {//Varargs가변인자

	public static void main(String[] args) {
		int nSum = sum(1,2,3,4,5,6,7,8,9,10);
		String sCal = cal("+",1,2,3,4,5,6,7,8,9,10);
		System.out.println(nSum);
		System.out.println(sCal);
	}
	
	static int sum(int num1, int... nums) {//처음숫자 num1을 제외하고 배열화
		int result = num1;//모든 매개변수의 합을 구할려면 num1값을 처음에 넣어준다.
		
		for (int i = 0; i < nums.length; i++) {
			result += nums[i];//nums는 내가 넣은 매개변수의 갯수 -1 이다.
		}
		return result;
	}
	static String cal(String ch, int... nums) {//모든 숫자 사이에 문자 표시
		String result = "";
		int s = 0;
		if(ch.equals("+")) {
			for (int i = 0; i < nums.length; i++) {
				s += nums[i];
				if(i == nums.length-1) result += nums[i];
				else result += nums[i] + ch;
			}
		}
		result += " = " + s;
		return result;
	}
}

package java_11_10;

public class RecursiveCall {//RecursiveCall : 재귀호출
	
	
	public static void main(String[] args) {
		System.out.println(square(10));
	}
	//재귀호출 : 메서드내에서 자신의 이름에 해당하는 메서드를 호출시
	//재귀호출 메서드는 조건식을 사용하여 무한호출이 되지 않도록 탈출 시켜줘야한다.
	static int square(int num) {//2의 num승을 계산한다.		
		if(num == 1) return 2;
		return 2*square(num-1);
	}
	
}

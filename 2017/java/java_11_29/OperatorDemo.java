package java_11_29;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class OperatorDemo {
	private static List<Integer> list = Arrays.asList(
				(int)(Math.random()*100+1),
				(int)(Math.random()*100+1),
				(int)(Math.random()*100+1),
				(int)(Math.random()*100+1),
				(int)(Math.random()*100+1)
			);
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = list.get(0);
		for(int score : list) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("점수 : " + list);
		int max = maxOrMin(
			(num1, num2) -> {
				if(num1 >= num2) return num1;
				else return num2;
			}
		);
		System.out.println("최고 점수는 : " + max);
		
		int min = maxOrMin(
			(num1, num2) -> {
				if(num1 <= num2) return num1;
				else return num2;
			}
		);
		System.out.println("최하 점수는 : " + min);
	}
}

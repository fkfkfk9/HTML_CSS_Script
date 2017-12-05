package java_12_01;

import java.util.Arrays;
import java.util.List;

public class IntStream {

	public static void main(String[] args) {
		List<FbPlayer>list = Arrays.asList(
				new FbPlayer("박지성", 13, 10),
				new FbPlayer("호날두", 7, 40),
				new FbPlayer("손흥민", 7, 25)
			);
		double avg = list.stream().mapToInt(FbPlayer::getGoal).average()
						.getAsDouble();
		//메소드를 사용하기 위에 .을 찍을 때 개행이후 해도 괜찮다.
		//mapToInt의 리턴타입은 IntStream이다 이런식의 리턴타입이 나온다면
		//중간처리 메소드라는것이고 이후 추가 작업을 계속 할 수 있다.
		//위에 코드는 list의 데이터를 스트림화 해서 인트값만 빼오고 그걸 평균을 구해 더블타입으로
		//리턴 받는 것이다.
		
		System.out.println("평균점수 : " + avg);
	}

}

class FbPlayer{
	private String name;
	private int number;
	private int goal;
	
	public FbPlayer(String name, int number, int goal) {
		this.name = name;
		this.number = number;
		this.goal = goal;
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	public int getGoal() {return goal;}
	public void setGoal(int goal) {this.goal = goal;}
}
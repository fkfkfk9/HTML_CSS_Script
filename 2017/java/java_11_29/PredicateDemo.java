package java_11_29;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
	private static List<FootBall> list = Arrays.asList(
			new FootBall("박지성", "맨유", 13, 10),
			new FootBall("손흥민", "토트넘", 7, 20),
			new FootBall("루카쿠", "맨유",  9, 25),
			new FootBall("헤리 케인", "토트넘", 10, 30)
	);
		
	public static double avg(Predicate<FootBall> predicate) {
		int count = 0, sum = 0;
		for(FootBall fb : list) {
			if(predicate.test(fb)) {
				count++;
				sum += fb.getGoal();
			}
		}
		return (double) sum / count;
	}
		
	public static void main(String[] args) {
		double manuAvg = avg( t ->  t.getTeam().equals("맨유") );
		System.out.println("맨유가 넣은 골 평균 : " + manuAvg);
			
		double tothAvg = avg( t ->  t.getTeam().equals("토트넘") );
		System.out.println("토트넘이 넣은 골 평균 : " + tothAvg);
	}
}

class FootBall {
	private String name;
	private String team;
	private int number;
	private int goal;
	
	public FootBall(String name, String team, int number, int goal) {
		this.name = name;
		this.team = team;
		this.number = number;
		this.goal = goal;
	}
	
	public String getName() { return name; }
	public String getTeam() { return team; }
	public int getNumber() { return number; }
	public int getGoal() { return goal; }
}

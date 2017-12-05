package java_12_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		List<FootBall>list = Arrays.asList(
					new FootBall("박지성", 13, "맨유"),
					new FootBall("호날두", 7, "레알")
				);
		Stream<FootBall> st = list.stream();
		
		st.forEach(fb->{
			String name = fb.getName();
			int number = fb.getNumber();
			String team = fb.getTeam();
			System.out.println(name + "선수의 등번호는 " + number
					+ "이고 팀은 " + team + "이다.");
		});
	}

}

class FootBall{
	private String name;
	private int number;
	private String team;
	
	public FootBall(String name, int number, String team) {
		this.name = name;
		this.number = number;
		this.team = team;
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	public String getTeam() {return team;}
	public void setTeam(String team) {this.team = team;}
	
}

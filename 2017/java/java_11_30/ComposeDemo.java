package java_11_30;

import java.util.function.Function;

public class ComposeDemo {

	public static void main(String[] args) {
		//Data는 입력매개변수, 리턴값은 Team
		//즉 Data -> Team으로 매핑해서 리턴
		Function<Football, Team> fun1;
		Function<Team, String> fun2;
		Function<Football, String> fun;
		String teamName = "";
		
		fun1 = (t) -> t.team;//
		fun2 = (t) -> t.teamname;
		
		fun = fun1.andThen(fun2);
		teamName = fun.apply(new Football("박지성", 13, new Team("맨유", "EPL")));
		System.out.println("팀명 : " + teamName);
		
		fun = fun2.compose(fun1);
		teamName = fun.apply(new Football("손흥민", 7, new Team("토튼햄", "EPL")));
		System.out.println("팀명 : " + teamName);
	}

}

class Team{
	String teamname;
	String league;
	
	public Team(String teamname, String league) {
		this.teamname = teamname;
		this.league = league;
	}
}
class Football{
	String name;
	int number;
	Team team;
	
	public Football(String name, int number, Team team) {
		this.name = name;
		this.number = number;
		this.team = team;
	}
}


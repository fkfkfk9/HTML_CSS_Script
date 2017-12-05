package java_12_04;

import java.util.ArrayList;

public class MapDemo {

	public static void main(String[] args) {
		ArrayList<FbPlayer> al  = new ArrayList<>();
		al.add(new FbPlayer("박지성", 13, 10));
		al.add(new FbPlayer("손흥민", 7, 22));
		al.add(new FbPlayer("호날두", 7, 50));
		al.add(new FbPlayer("데헤아", 1, 0));
		
		al.stream().mapToInt(s->s.getGoal()).forEach(System.out::println);
	}

}

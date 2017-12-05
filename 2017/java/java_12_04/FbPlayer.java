package java_12_04;

public class FbPlayer {

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

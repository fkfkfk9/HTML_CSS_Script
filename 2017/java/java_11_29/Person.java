package java_11_29;

public class Person {
	private int idx;
	private String name;
	private int age;
	
	public Person(int idx, String name, int age) {
		this.idx = idx;
		this.name = name;
		this.age = age;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

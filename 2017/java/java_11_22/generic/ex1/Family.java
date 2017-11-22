package java_11_22.generic.ex1;

public class Family<T> {
	private int age;
	private T name;
	private T gender;
	static int count = 0;
		
	public Family() {count++;}
	public Family(int age, T name, T gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
		count++;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public T getGender() {
		return gender;
	}

	public void setGender(T gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "나이 : " + age + ", 이름 : " + name + ", 성별 : " + gender;		
	}
}

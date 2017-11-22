package java_11_22.generic.ex1;

public class Family2<T> {
	int age;
	T name;
	T sex;
	static int count = 0;
	
	public Family2(int age, T name, T sex) {
		this.age = age;
		this.name = name;
		this.sex = sex;
		count++;
	}
	@Override
	public String toString() {
		return String.format("이름 : %s, 나이 : %3d, 성별 : %s", name, age, sex);
	}
}

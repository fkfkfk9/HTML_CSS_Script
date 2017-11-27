package java_11_27;

public class Test {

	public static void main(String[] args) {
		Ex1 e1 = new Ex1();
		int sum = e1.stringsum("9742");
		System.out.println(sum);
		
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름 : " + s.name);
		System.out.println("총점 : " + s.getTotal());
		System.out.println("평균 : " + s.getAverage());
	}

}

class Ex1{
	int stringsum(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Integer.parseInt(str.charAt(i) + "");
//			sum += str.charAt(i) - '0'; 아스키 코드를 이용한 방법
		}
		return sum;
	}
}
class Student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int getTotal() {
		return kor+eng+math;
	}
	double getAverage() {
		return Math.round((getTotal()/3.0)*10)/10.0;
		//소수 두째자리에서 반올림하기 위해 10을 곱한다음 반올림을 한다음 10.0을 나눠 다시 소수로만듬
	}
}

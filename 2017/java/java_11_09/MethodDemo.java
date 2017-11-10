package java_11_09;

public class MethodDemo {

	public static void main(String[] args) {
		Sungjuk su = new Sungjuk();//성적 객체 생성
		int kor = 77;//점수 변수를 3개 정의한다.
		int eng = 88;
		int mat = 100;
		System.out.println("세 점수의 총 합은 : " + su.getSum(kor, eng, mat));
		//int타입 변수 3개를 넣어 총합을 가져옴
		System.out.printf("세 점수의 평균은  : %5.2f\n", su.getAverage(kor, eng, mat));
		//int타입 변수 3개를 넣어 평균을 가져옴 5.2f는 5자리중 소수점2자리 까지 넣은 소수를 말함
		System.out.println("국어의 등급 : " + su.getGrade(kor));
		System.out.println("영어의 등급 : " + su.getGrade(eng));
		System.out.println("수학의 등급 : " + su.getGrade(mat));
		//int타입 변수를 넣어 등급 출력
	}
}

class Sungjuk{
	public int getSum(int kor, int eng, int mat) {
		return kor+eng+mat;//매개변수 3개를 더해 리턴
	}
	public double getAverage(int kor, int eng, int mat) {
		return (kor+eng+mat)/3.0;//매개변수 3개 더한 값을 소수로 나눠 형을 바꿈
	}
	public char getGrade(int score) {
		char grade = ' ';//리턴할 char형 변수 선언 및 초기화
		if(score >= 90 && score <= 100) grade = 'A';//점수별 판단문
		else if(score >= 80 && score < 90) grade = 'B';
		else if(score >= 0 && score < 80) grade = 'C';
		else System.out.println("0~100 까지의 숫자를 입력하시오.");
		
		return grade;//점수별로 데이터를 넣어준 char타입 변수를 리턴
	}
}

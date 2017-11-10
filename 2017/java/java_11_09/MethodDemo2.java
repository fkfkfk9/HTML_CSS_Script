package java_11_09;

public class MethodDemo2 {

	public static void main(String[] args) {
		SungJuk2 su = new SungJuk2();//성적 객체 생성
		su.setKor(77);//점수 변수를 3개 정의한다.
		su.setEng(88);
		su.setMat(100);
		System.out.println("세 점수의 총 합은 : " + su.sum());
		System.out.printf("세 점수의 평균은  : %5.2f\n", su.avg());
		//int타입 변수 3개를 넣어 평균을 가져옴 5.2f는 5자리중 소수점2자리 까지 넣은 소수를 말함
		System.out.println("국어의 등급 : " + su.getGrade(su.getKor()));
		System.out.println("영어의 등급 : " + su.getGrade(su.getEng()));
		System.out.println("수학의 등급 : " + su.getGrade(su.getMat()));
	}
}

class SungJuk2{
	private int kor, eng, mat;
		
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int sum() {
		return this.kor+this.eng+this.mat;//매개변수 3개를 더해 리턴
	}
	public double avg() {
		return (this.kor+this.eng+this.mat)/3.0;//매개변수 3개 더한 값을 소수로 나눠 형을 바꿈
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

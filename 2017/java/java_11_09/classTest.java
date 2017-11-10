package java_11_09;
import java.util.*;

public class classTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//입력받는 스케너 객체를 만듬
		Calculator cal;//1)객체 선언, 참조변수 아직은 NULL값이다.
		cal = new Calculator();//2)객체생성 객체가 있는 메모리의 주소를 대입한다.
		//Calculator()는 생성자 메서드 클래스명과 이름이 동일하다.
		//Calculator cal = new Calculator(); 한줄로도 할 수 있다.
		//객체가 가리키는 기억장소의 구성요소(멤버필드, 메서드)를 접근할 때
		//접근문법 : 객체명.필드, 객체명.메서드명();
		System.out.println("---- 계산기 ----");
		System.out.println("계산할 숫자 2개를 입력해 주세요.");
		cal.setCalNUm1(Integer.parseInt(cal.scan(scan)));
		//스케너를 매개변수로 보내 입력값을 받아온다.
		cal.setCalNUm2(Integer.parseInt(cal.scan(scan)));		
		System.out.println("+,-,*,/ 중 원하는 계산기능을 선택하세요.");
		char op = cal.scan(scan).charAt(0); 
		
		if(op == '+') System.out.println(cal.getCalNUm1() + " + " + 
				cal.getCalNUm2() + " = " + cal.add());
		else if(op == '-') System.out.println(cal.getCalNUm1() + " - " + 
				cal.getCalNUm2() + " = " + cal.sub());
		else if(op == '*') System.out.println(cal.getCalNUm1() + " x " + 
				cal.getCalNUm2() + " = " + cal.mul());
		else if(op == '/') System.out.println(cal.getCalNUm1() + " / " + 
				cal.getCalNUm2() + " = " + cal.div());
		else System.out.println("입력하신건 연산 기호가 아닙니다.");
	}
}
/*메서드 만들 때
	[접근자] 반환(리턴)타입 메서드명(매개변수1, 매개변수2.......){
		return 결과값(반환값); return과 반환타입은 같아야한다.
	}
	[접근자] void 매서드명(매개변수1, 매개변수2.....)선언부{
		구현부
	}void : 리턴값이 없다.	
	매서드의 경우 매개변수는 여러개가 있을수도 아예 없을수도 있다.
	접근자 또한 있어도 없어도 상관없다.
	
	메소드를 사용할때 컨트롤키 + 클릭을 하면 해당 메소드를 찾아간다.
*/

class Calculator {
	/* 계산기의 속성(멤버 변수, 멤버 필드)  */
	private int calNUm1;//계산해줄 숫자1
	private int calNUm2;//계산해줄 숫자2
	
	/* 멤버 메서드 */
	
	public int getCalNUm1() {//첫번째 숫자값을 리턴해준다.
		return calNUm1;
	}

	public void setCalNUm1(int calNUm1) {//첫번째 숫자값을 설정한다.
		this.calNUm1 = calNUm1;
	}

	public int getCalNUm2() {//두번째 숫자값을 리턴해준다.
		return calNUm2;
	}

	public void setCalNUm2(int calNUm2) {//두번째 숫자값을 리턴해준다.
		this.calNUm2 = calNUm2;
	}
	
	public int add() {//더하기 프로그램
		return this.calNUm1 + this.calNUm2;
	}
	public int sub() {//더하기 프로그램
		return this.calNUm1 - this.calNUm2;
	}
	public int mul() {//더하기 프로그램
		return this.calNUm1 * this.calNUm2;
	}
	public double div() {//더하기 프로그램
		return this.calNUm1 / (double)this.calNUm2;
	}
	public String scan(Scanner sc) {//계산기에 필요한 데이터를 입력받기 위한 메소드
		return sc.nextLine();
	}
}

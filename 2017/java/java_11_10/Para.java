package java_11_10;

public class Para {

	public static void main(String[] args) {
		testClass tc = new testClass();
		tc.iNum = 8;
		int iNum = 13;
		
		System.out.println("trans 메소드 사용 전!!!");
		System.out.println("tc.iNum : " + tc.iNum);
		System.out.println("iNum : " + iNum);
		//같은 클래스의 메소드이기 때문에 메소드명만 사용
		trans(iNum);//매개변수가 값
		obtrans(tc);//매개변수가 오브젝트
		
		System.out.println("trans 메소드 사용 후!!!");
		System.out.println("tc.iNum : " + tc.iNum);
		//값이 있는 주소를 보냈기 때문에 변화가 잇다.
		System.out.println("iNum : " + iNum);//값만 보내서 변화가 없다.		
	}
	
	//메서드가 호출이 되면서 생성했던, 지역변수, 매개변수의 기억장소는
	//메서드 종료와 함께 기억장소가 소멸된다.
	static void trans(int num) {//매개변수가 원소변수
		num = 88;
		System.out.println("입력된 값은 88로 변형 되었습니다.");
	}
	static void obtrans(testClass tc) {//매개변수가 오브젝트 즉 레퍼런스 변수
		tc.iNum = 88;
		System.out.println("입력된 값은 88로 변형 되었습니다.");
	}
}

class testClass{
	int iNum;
}
package java_11_10;

public class ConstructorTest {

	public static void main(String[] args) {
		Constructor ct = new Constructor();//Constructor()생성자 메소드이다.
		ct.cNum = 8;
		Constructor2 ct2 = new Constructor2(13);//정수를 넣어주지 않으면 에러
		System.out.println("Constructor2 변수값 : " + ct2.cNum);
	}

}

class Constructor{//Constructor : 생성자
	int cNum;
}

class Constructor2{
	int cNum;
	
	Constructor2(int num){//객체를 만들때 int변수를 요구한다.
		this.cNum = num;
	}
}
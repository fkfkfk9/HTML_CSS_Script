package java_11_23;

public class CardTest {

	public static void main(String[] args) {
		Card c = new Card();
		c.methodC();//값을 넣어주지 않으면 디폴트 값으로 0부터 순서대로 넣어준다.
	}

}
/*
	열거형 이름 : 클래스 수준의 의미. 사용자 정의 데이터타입
	상수명 : static final
	enum 열거형 이름{상수명1, 상수명2, 상수명3 ...}
*/
enum CardSet{CLOVER, SPACE, DIAMOND, HART}
class Card{
	//상수를 생성 고유명사
	static final int CLOVER = 0;
	
	int a = CLOVER;
	CardSet cs;
	//cs = CardSet. 에러
	
	public void methodA(){
		cs = CardSet.CLOVER;
		
		if(cs == CardSet.SPACE) {
			System.out.println("맞다.");
		}else {
			System.out.println("틀리다.");
		}
	}
	public void methodB(CardSet cs) {//매개변수로도 enum(열거형)을 쓸 수 있다.
		switch(cs) {
			case DIAMOND://CardSet.DIAMOND는 에러 스위치상에선 DIAMOND만 입력가능
		}
	}
	public void methodC() {
		CardSet[] cardArr = CardSet.values();
		for (CardSet cs : cardArr) {
			System.out.println(cs.name() + " = " + cs.ordinal());
		}
	}
}

package java_11_14;

public class SingletonEx {
	
	/*
		싱글톤 패턴 : 클래스 패턴 디자인기법중 하나
		프로젝트를 할 때 클래스를 이용해서 단 한개의 객체를 생성하는 기법이다.
		자바를 하면서 전략에는 클래스패턴 디자인이 있고 
		전술에는 리팩토링, EFFECTIVE자바가 있다.
	*/	
	public static void main(String[] args) {
		Singleton s = Singleton.getSingleton();
		//객체를 생성하는게 아니라 메소드를 통해 가져온다.
		s.pnt();
	}

}

//생성자가 private일 경우 후손에서 조상클래스의 생성을 하는것이 불가능 함으로
//사실상 상속이 불가능하다. 상속이 불가능함을 표시하기 위해 final을 넣어주는편이 좋다.
final class Singleton{
	private static Singleton s = new Singleton();//리턴 시키기 위한 인스턴스 객체변수
	//디폴트 생성자 메서드
	private Singleton() {}
	public static Singleton getSingleton() {
		//생성이 불가능 하기 때문에 외부에서 메소드로 접근해 사용할 수 있도록 public static로 만듬
		if(s == null) s = new Singleton();
		return s;//스테틱 변수로 정의해놓은 객체를 리턴해줌
	}
	void pnt() {
		System.out.println("싱글톤 성공");
	}
	//즉 외부에서 메소드를 통해서만 객체에 접근 가능하고 생성은 불가능하다.
}

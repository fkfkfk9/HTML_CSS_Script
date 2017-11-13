package java_11_13;

public class TestSample {

	public static void main(String[] args) {
		apple a = new apple();
		orange o = new orange();
		
		System.out.println("사과의 색은 " + a.color + "색 입니다.");
		a.taste();
		System.out.println("오렌지의 색은 " + o.color + "색 입니다.");
		o.taste();
	}

}

class fruit{
	String color;
	
	void taste() {
		
	}
}
class apple extends fruit{
	apple(){
		super();
		this.color = "빨강";		
	}
	void taste() {
		System.out.println("사과는 단맛이 있습니다.");
	}
}
class orange extends fruit{
	orange(){
		super();
		this.color = "노랑";
	}	
	void taste() {
		System.out.println("오렌지는 신맛이 있습니다.");
	}
}
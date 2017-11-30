package java_11_30;

import java.util.function.Consumer;

public class ConsumerandThenDemo {

	public static void main(String[] args) {
		//매개변수를 제공하고 리턴값이 없는 특징. void accept(T t)
		Consumer<Data> con1 = (t) -> {
			System.out.println("con1 : " + t.sv);
		};
		Consumer<Data> con2 = (t) -> {
			System.out.println("con2 : " + t.iv);
		};// END 재정의
		//호출
		con1.accept(new Data("박지성", 13));
		con2.accept(new Data("손흥민", 7));
		Consumer<Data> con = con1.andThen(con2);//두 람다식을 같이 작업하게 해줌
		con.accept(new Data("fkfkfk9", 88));
	}

}

class Data{
	String sv;
	int iv;
	
	public Data(String sv, int iv) {
		this.sv = sv;
		this.iv = iv;
	}
}



package java_11_22;

/*일반클래스
public class Data<T> {
	int iv;
	String sv;
}

*/
//제네릭 클래스
//<T> : 타입 파라미터(매개변수)
//원시타입이라 한다.
//구지 T가 아니라 무슨 글을 써도 된다. 갯수도 여러개 사용가능하다.

public class Data<T, P> {
	P iv;
	T sv;
	//static T st; 인스턴스가 아니면 제네릭은 오류가 난다. 타입이 정해지기 전에 메모리가 읽음
	T[] item;
	//T[] item2 = new T[10] 지원안됨 이것도 타입이 정해지기 전에 메모리가 생성되기 때문에 불가
	public P getIv() {
		return iv;
	}
	public void setIv(P iv) {
		this.iv = iv;
	}
	public T getSv() {
		return sv;
	}
	public void setSv(T sv) {
		this.sv = sv;
	}
	
}

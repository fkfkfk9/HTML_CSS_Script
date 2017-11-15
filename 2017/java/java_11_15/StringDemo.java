package java_11_15;

public class StringDemo {

	public static void main(String[] args) {
		String str1 = new String("hello");
		String str2 = new String("hello");
		Obtest ot = new Obtest(13, "오브젝트", 8, 33);
		Obtest ot2 = null;
		//new String를 사용해 새로운 객체로 만들었기 때문에 주소값은 다르고 값만 같다.
		//str1 = "hello"로 정의시 "hello"를 메모리에 적고 String변수가 가리키기만 하기때문에
		//str2 = "hello"로 정의해도 새 메모리에 만드는게 아니라 기존의 "hello"를 가리킨다.
		
		//String Class에서 equals()메서드를 오버라이딩 해놓음
		//오브젝트에선 객체 주소를 비교하지만 스트링에선 값을비교함
		//오브젝트는 모든 클래스의 조상이기 때문에 어떤 클레스를 만들던
		//equals를 오버라이딩하여 용도에 맞게 변경할 수 있다.
		if(str1.equals(str2)) {
			System.out.println("같다.");
		}
		//오브젝트의 해쉬코드는 객체의 주소값이 들어가기때문에 절개로 같을 수가 없다.
		//스트링타입의 변수의 해쉬코드가 같게 나오는건 String클래스에서 오버라이딩을 했다는것이다.
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		/*object클래스상 tostring()
		return getClass().getName()+"@"+Integer.toHexString(hashCode());*/
		System.out.println(str1.toString());
		System.out.println(ot.toString());
		System.out.println(ot.iv + ot.sv + ot.d.x + ot.d.y);
		//하지만 string타입에선 값을 출력하는 내용으로 오버라이딩 되어있다.
		
		/* clone() 객체를 복사한다. 
		 객체 뿐만 아니라 Arraylist같은 java.util의 클래스들은 clone를 통해 복사가능 */
		ot2 = (Obtest)ot.clone();//Object형으로 리턴하기 때문에 형변환 필요
		System.out.println(ot2.toString());//새 객체를 만들어 복사하기 때문에 주소값 다름
		System.out.println(ot2.iv + ot2.sv + ot2.d.x + ot2.d.y);//데이터도 같다.
		Obtest ot3 = ot.deepclone();
		System.out.println(ot3.toString());//새 객체를 만들어 복사하기 때문에 주소값 다름
		System.out.println(ot3.iv + ot3.sv + ot3.d.x + ot3.d.y);//데이터도 같다.
		//하지만 얕은 복사는 data객체를 표한하는 d는 값은 같지만 주소값까지 같다.
		//반면 깊은 복사는 새로운 객체를 생성해서 넣어주기 때문에 객체까지 다르다.
		ot.sv = "객체지향";
		ot.d.x = 888;
		ot.d.y = 333333;//값은 ot만 바꿔주지만
		System.out.println("ot " + ot.iv + ot.sv + ot.d.x + ot.d.y);
		System.out.println("ot2 " + ot2.iv + ot2.sv + ot2.d.x + ot2.d.y);
		//ot2까지 값이 바뀌는걸 확인 할 수있다. 참조값이 같기 때문이다.
		System.out.println("ot3 " + ot3.iv + ot3.sv + ot3.d.x + ot3.d.y);
		//ot3는 영향이 없다.
	}
}

class Obtest implements Cloneable{//clone를 사용할려면 Cloneable이 상속되야 한다.
								  //아니면 예외 발생
	int iv;
	String sv;
	Data d;
	
	Obtest(int iv, String sv, int x, int y){
		this.iv = iv;
		this.sv = sv;
		this.d = new Data(x, y);
	}
	//부모클래스 Object - protected Object clone();
	//protected를 오버라이딩 해주기 때문에 portected나 public만 가능
	public Object clone() {//얕은 복사
		Object obj = null;
		try {
			obj = super.clone();//예외처리를 해줘야만 사용가능하기 때문에 필수 과정
		} catch (Exception e) {}
		return obj;
	}
	//변수는 상관 없지만 객체까지 복사해야 된다면 위의 clone를 하였을 경우 같은 객체를 참조한다.
	//그래서 아래와같이 중간에 객체를 생성시켜 값을 넣어주는 과정이 필요하다.
	public Obtest deepclone() {
		Object obj = null;
		try {
			obj = super.clone();//예외처리를 해줘야만 사용가능하기 때문에 필수 과정
		} catch (Exception e) {}
		Obtest ot = (Obtest)obj;
		//ot.객체 = new 객체(데이터1, 데이터2...) 새 객체가 값만 복사되어 들어감
		ot.d = new Data(this.d.x, this.d.y);
		return ot;
	}
}

class Data{
	int x;
	int y;
	
	Data(int x, int y){
		this.x = x;
		this.y = y;
	}
}
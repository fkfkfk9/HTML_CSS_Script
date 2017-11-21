package java_11_21;

import java.util.HashSet;
import java.util.Objects;

public class HashSetDemo2 {

	public static void main(String[] args) {
		HashSet<Person> hs = new HashSet<Person>();
		//기존의 add메소드는 주소값만 같다면 데이터값이 같아도 주소값이 중복이 아니기 때문에
		//같은값도 추가되었다.
		hs.add(new Person("user01", "1111", "02-555-5555"));		
		hs.add(new Person("user01", "1111", "02-555-5555"));
		hs.add(new Person("user01", "1111", "02-555-5556"));
		//add문은 hashCode()와 equals()문이 호출하여 데이터 중복을 피하기 때문에
		//두값을 모두 오버라이딩 해줘야만 데이터값 중복을 피 할수 있다.
		
		System.out.println(hs);//toString 메소드가 출력된다.
		//오버라이딩 하지 않으면 주소값이 간다.
	}
}

class Person{
	String userid;
	String passwd;
	String pNumber;
	
	Person(String userid, String passwd, String pNumber){
		this.userid = userid;
		this.passwd = passwd;
		this.pNumber = pNumber;
	}
	
	public boolean equals(Object obj) {//오브젝트의 equals는 주소값을 비교하기 때문에
		//주소값이 아닌 데이터값을 비교하기 위해서 오버라이딩함
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return userid.equals(p.userid) && passwd.equals(p.passwd) &&
					pNumber.equals(p.pNumber);//두 인스턴스의 값이 같다면 true리턴
		}
		return false;//이외의 값은 전부 펄스 		
	}
	public int hashCode() {//add메소드는 해쉬코드값도 동일해야 중복처리 된다.
		return Objects.hash(userid, passwd, pNumber);//1.8버전 추가
		//같은 값이 들어온다면 같은 int값이 리턴된다.
		//(userid+passwd+pNumber).hashCode() //String클래스에서 사용되는 방법 결과는 같다.
	}
	
	public String toString() {//출력할 때 변수명만 입력시 출력문을 리턴해준다.
		return this.userid + " | " + this.passwd + " | " + this.pNumber;
	}
}

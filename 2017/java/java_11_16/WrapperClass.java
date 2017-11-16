package java_11_16;

public class WrapperClass {

	public static void main(String[] args) {
		/*
			객체지향 개념에선 모든것이 객체가 되야하지만 기본데이터 타입중 원소변수 타입이있다.
			이런 값타입 데이터를 객체화 시켜 쓰기 위해 사용하는게 WrapperClass이다.
		*/
		Integer i1 = new Integer(88);
		Integer i2 = new Integer(88);
		int iv1 = 33;
		int iv2 = 33;
		System.out.println("참조타입인 i1,i2와 원소변수 타입인 iv1,iv2를 비교");
		System.out.println("i1 == i2 : " + (i1 == i2));
		System.out.println("iv1 == iv2 : " + (iv1 == iv2));
		System.out.println("i1 equal i2 : " + i1.equals(i2));
		//주소값이 다른대도 트루가 나온다. equals가 값비교로 오버라이딩 됬다는걸 알 수 있다.
		System.out.println("iv1 equal iv2 는 객체가 아니라 메소드가 없다.");
		System.out.println("i1 compareTo i2 : " + i1.compareTo(i2));
		//값이 같으면 0 다르면 -1
		System.out.println("i1 ToString : " + i1.toString() + " i2 : " + i2.toString());
		//오버라이딩 되어 ToString도 해당주소의 데이터를 리턴해줌
		int iv3 = i1.intValue();
		System.out.println(iv3);
		/*
			Boxing : 값타입 변수의 데이터를 참조타입의 주소가 가르키는 영역에 복사하여 저장하는것
			1.5이전 버전에선 박싱이 중요했지만 지금은 값타입과 참조타입이 연산이 가능하다.
			박싱 : 값타입을 참조타입의 형으로변환해서 사용하는기술
			언박싱 : 참조타입형을 기본형으로 변환해서 사용하는 기술
		*/
	}

}

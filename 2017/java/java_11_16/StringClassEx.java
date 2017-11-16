package java_11_16;

public class StringClassEx {

	public static void main(String[] args) {
		/*
			String 클래스 : 문자열 데이터 작업목적
			내부적으로는 Char[] 배열로 구성이 되어있음
			String 타입의 2데이터를 더한다면 해당 주소 데이터들이 더해지는게 아니라
			해당 주소 데이터 2개는 따로 남고 더한 데이터가 추가되어 그 주소를 가리키게 된다.
			즉 +연산자를 할수록 String주소가 생성되기 때문에 메모리 공간을 차지하므로 비효율적
			이렇게 결합이나 추출등 문자열을 다루는 작업이 많아질경우 StringBuffer클래스 사용
		*/
		String str1 = "fkfkfk9";
		String str2 = "fkfkfk9";
		//같은 데이터면 기존의 메모리에 있던 데이터의 주소를 가져오기 때문에 두 데이터는 같은주소
		System.out.println("str1 == str2 : " + (str1 == str2));
		//주소가 같은지 비교
		System.out.println("str1 equals str2 : " + (str1.equals(str2)));
		//데이터가 같은지 비교 Object의 equals는 주소비교인대 String에선 값비교로 오버라이딩됨
		str1 = new String("fkfkfk9");
		str2 = new String("fkfkfk9");
		//같은데이터지만 String객체를 생성해서 넣어줬기 때문에 주소가 다름
		System.out.println("str1 == str2 : " + (str1 == str2));
		//주소가 같은지 비교
		System.out.println("str1 equals str2 : " + (str1.equals(str2)));
		//값이 같은지 비교
	}

}

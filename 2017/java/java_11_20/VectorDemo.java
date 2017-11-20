package java_11_20;

import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		//Vector Class는 이전버전의 호환성 목적으로 지원할 뿐
		//ArrayList Class사용을 권장한다.
		
		Vector v = new Vector();
		v.add("박지성");
		v.add("차범근");
		v.add("손흥민");
		
		System.out.println(v);
		System.out.println("저장된 크기 :" + v.size());
		System.out.println("지정 된 메모리 :" + v.capacity());//디폴트값 10
		
		v.trimToSize();//현재 저장된 크기만큼 메모리 사이즈를 줄여준다.ㅣ	
		System.out.println("trimToSize");
		System.out.println(v);
		System.out.println("저장된 크기 :" + v.size());
		System.out.println("지정 된 메모리 :" + v.capacity());

		v.ensureCapacity(8);//메모리 크기를 지정한 int값 만큼 늘린다.
		System.out.println("ensureCapacity");
		System.out.println(v);
		System.out.println("저장된 크기 :" + v.size());
		System.out.println("지정 된 메모리 :" + v.capacity());

		v.setSize(13);//저장된 크기 자체를 늘리고 늘린건 null값이 들어간다.
		//위에서 늘려놓은 메모리크기 보다 저장된 크기가 거키면서 내부적으로 메모리크기도 늘린다.
		//이처럼 자동적으로 메모리크기를 증가 시킬때는 기존의 크기에 2배를 증가시킨다.
		System.out.println("setSize");
		System.out.println(v);
		System.out.println("저장된 크기 :" + v.size());
		System.out.println("지정 된 메모리 :" + v.capacity());
		
		v.clear();//크기 즉 데이터는 전부 사라지지만 지정된 메모리는 남는다.
		System.out.println("clear");
		System.out.println(v);
		System.out.println("저장된 크기 :" + v.size());
		System.out.println("지정 된 메모리 :" + v.capacity());
	}

}

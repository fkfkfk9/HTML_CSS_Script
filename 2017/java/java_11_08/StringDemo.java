package java_11_08;

public class StringDemo {

	public static void main(String[] args) {
		String str= "Java";//Java라는 데이터가 저장된 메모리의 레퍼런스를 str이 저장한다.
		str = str + "8";
		//str과 "8"이 기록된 레퍼런스에서 값을 새로운 레퍼런스로 불러와 두 값을 합친다.
		//즉 "Java", "8", "Java8" 3개의 데이터가 메모리에 저장되있고 기존의 값을 수정하는 것은 아니다.
		//str은 Java의 레퍼런스를 저장하다가 Java8값의 레퍼런스를 저장하게 된다. 
		System.out.println(str);
	}

}

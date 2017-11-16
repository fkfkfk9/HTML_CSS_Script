package java_11_16;

import java.util.StringJoiner;

public class FileType {

	public static void main(String[] args) {
		String textFile = "Head First Java.txt";
		int index = textFile.indexOf('.');//문자열중 하나의 위치를 찾음
		
		String fileName = textFile.substring(0, index);
		//처음부터 인덱스까지 가져와 스트링 파일에 넣어준다.
		String type = textFile.substring(index+1);//해당위치부터 끝까지 가져옴
		System.out.println(fileName);
		System.out.println(type);
		//파일의 데이터 타입만 때고 이름만 가져올때나.
		//여러타입의 데이터중에 특정 타입의 데이터만 찾아서 가져오고 싶을때 유용하다.
	}

}

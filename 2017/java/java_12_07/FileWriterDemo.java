package java_12_07;

import java.io.File;
import java.io.FileWriter;

public class FileWriterDemo {

	public static void main(String[] args) throws Exception{
		//1)파일객체 생성
		File file = new File("C:/Users/user/Desktop/javaFile/writerfile.txt");
		
		//2)문자기반의 파일출력 스트림객체 생성
		FileWriter fw = new FileWriter(file, true);
		//true로 하면 기존 텍스트파일에 내용을 추가
		
		fw.write("스트림 기반이 아닌 문자 기반의 라이터 클래스 사용중" +  "\n");
		fw.write("특별한 작업 없이 바로 입력 가능" + "\t \r \n" + "!!!!");
		fw.flush();
		fw.close();
	}

}

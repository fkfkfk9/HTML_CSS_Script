package java_12_07;

import java.io.FileInputStream;

public class fileInputStreamDemo {

	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("D:/YooJongHyun/workspace/JAVA/Hyundai2/src/java_12_06/FileDemo.java");
		int read;
		while((read = fis.read()) != -1) {//더 이상 읽을 데이터가 없다면 -1리턴
			System.out.write(read);//write는 인트형을 자동으로 문자로 변환시킨다.
		}
		fis.close();
	}

}

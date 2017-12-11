package java_12_07;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fileOutputStreamDemo {

	public static void main(String[] args) throws Exception{
		String PngFilePath = "D:/YooJongHyun/workspace/JAVA/Hyundai2/src/java_12_07/test.png";
		String copyPngFilePath = "C:/Users/user/Desktop/javaFile/img/test.png";
		
		FileInputStream fis = new FileInputStream(PngFilePath);
		FileOutputStream fos = new FileOutputStream(copyPngFilePath);
		
		int read;
		byte[] readByte = new byte[88];
		while( (read = fis.read(readByte)) != -1 ) {
			fos.write(readByte, 0, read);
		}
		
		fos.flush();
		fos.close();
		fis.close();
		
		System.out.println("Copy Succes!!!");
	}

}

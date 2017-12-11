package java_12_07;

import java.io.FileReader;

public class FileReaderDemo {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("D:/YooJongHyun/workspace/JAVA/Hyundai2/src/java_12_06/FileDemo.java");
		int read;
		String str = "";
		char[] buf = new char[88];
		while((read = fr.read(buf)) != -1) {
			str = new String(buf, 0, read);
			System.out.println(str);
		}
		fr.close();
	}

}

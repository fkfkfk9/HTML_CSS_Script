package java_12_06;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo {

	public static void main(String[] args) throws Exception {
		Reader rd = new FileReader("C:/Users/user/Desktop/inputtest.txt");
		int read = 0;
		while( true ) {
			read = rd.read();
			if(read == -1) break;
			System.out.print((char)read);
		}
		System.out.println();
		rd.close();
		rd = new FileReader("C:/Users/user/Desktop/inputtest2.txt");
		char[] buf = new char[3];
		String data = "";
		while( true ) {
			read = rd.read(buf);
			//buf배열의 크기 만큼 텍스트 내용을 읽어서 전달함
			System.out.print(read);
			if(read == -1) break;
			data += new String(buf, 0, read);
		}
		System.out.println("\n" + data);
		rd.close();
		char[] buf2 = new char[7];
		rd = new FileReader("C:/Users/user/Desktop/IOTest.txt");
		read = rd.read(buf2, 2, 2);
		//buf2배열의 2의 인덱스부터 텍스트 파일의 2개문자를 읽어와 넣는다. 나머지 공간은 널값
		System.out.println(read);
		for (int i = 0; i < buf2.length; i++) {
			System.out.println(buf2[i]);
		}
		rd.close();
	}

}

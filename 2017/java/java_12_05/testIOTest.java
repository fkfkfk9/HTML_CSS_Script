package java_12_05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class testIOTest {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/Users/user/Desktop/IOTest.txt");
		byte[] data = "Hello Java!!!".getBytes();
		os.write(data);
		os.flush();
		os.close();
		
		InputStream is = new FileInputStream("C:/Users/user/Desktop/IOTest.txt");
		byte[] readbyte = new byte[8];
		int read;
		String str = "";
		while(true) {			
			read = is.read(readbyte);			
			if(read == -1) break;			
			str += new String(readbyte, 0, read);
		}
		System.out.println(str);
		is.close();		
	}

}

package java_12_05;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {

	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("C:/Users/user/Desktop/inputtest.txt");
		int read;
		while(true) {
			read = is.read();//한개의 문자를 읽어옴
			if(is.read() == -1) break;//read()메서드가 읽어온 문자가 없을 경우 -1리턴
			System.out.print((char)read);
		}
		is.close();
		
		System.out.println();
		
		is = new FileInputStream("C:/Users/user/Desktop/output.txt");
		byte[] readbyte = new byte[10];
		String str = "";
		while(true) {
			//readbyte배열크기만큼 텍스트파을의 내용을 읽어와서 readbyte배열에 저장한다.
			read = is.read(readbyte);
			//배열 크기가 10이므로 10바이터씩 글자를 읽어옴
			System.out.println(read);
			if(read == -1) break;
			//readbyte배열의 내용을 읽어와서 String문자열로 변환하는 기능
			str += new String(readbyte, 0, read);
		}
		System.out.println(str);
		is.close();		
		
		is = new FileInputStream("C:/Users/user/Desktop/output.txt");
		readbyte = new byte[8];
		read = is.read(readbyte, 1, 3);
		//readbyte의 1번째 바이트부터 3개데이터를 입력한다. 내용은 텍스트파일의 첫 3글자
		for(int i=0; i<readbyte.length; i++) {
			System.out.println(readbyte[i]);
			System.out.println((char)readbyte[i]);
		}
		is.close();
	}

}

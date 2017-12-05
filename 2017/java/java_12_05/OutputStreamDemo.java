package java_12_05;

import java.io.*;

public class OutputStreamDemo {

	public static void main(String[] args) throws Exception{
		OutputStream os = new FileOutputStream("C:/Users/user/Desktop/output.txt");
		byte[] data = "asdasdqwe 1234".getBytes();//문자열을 바이트화해서 바이트배열에 넣음
		for(int i=0; i<data.length; i++) {
			os.write(data[i]);//스트림변수에 바이트를 저장한다.
		}
		os.flush();//스트림에 저장된 데이터를 텍스트파일에 쓴다.
		os.close();
		os = new FileOutputStream("C:/Users/user/Desktop/output.txt");
		data = "fkfkfk9 : 유종현".getBytes();
		os.write(data);
		os.flush();
		os.close();
		os = new FileOutputStream("C:/Users/user/Desktop/output.txt");
		data = "fkfkfk9 : 유종현".getBytes();
		os.write(data, 10, 9);//data배열에 10번째 바이트부터 9바이트의 데이터를 적는다.
		os.flush();
		os.close();
	}

}

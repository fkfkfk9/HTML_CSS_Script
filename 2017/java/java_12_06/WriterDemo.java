package java_12_06;

import java.io.FileWriter;
import java.io.Writer;

public class WriterDemo {

	public static void main(String[] args) throws Exception {		
		Writer wt = new FileWriter("C:/Users/user/Desktop/writer.txt");
		char[] buf = "fkfkfk9 : 유종현".toCharArray();//스트링을 문자형 배열로 바꾸는 메소드
		for (int i = 0; i < buf.length; i++) {
			wt.write(buf[i]);
		}
		wt.flush();
		wt.close();
		wt = new FileWriter("C:/Users/user/Desktop/writer2.txt");
		wt.write("asdqwer 1215141 ㅁㄹㅇㅁㄹㄴㅇㄹ");
		wt.flush();
		wt.close();
		wt = new FileWriter("C:/Users/user/Desktop/writer.txt");
		buf = "a;lksdf 12312 다나다라마바사".toCharArray();
		wt.write(buf);//(buf, 1, 2)이런식으로 원하는 데이터만 뽑아서 텍스트화 할 수도 있다.
		//outStream과 다른건 2를 적으면 2바이트가 들어가던것과 다르게 2글자가 들어간다.
		wt.flush();
		wt.close();
	}

}

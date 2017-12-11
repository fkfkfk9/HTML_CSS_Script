package java_12_07;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderDemo {

	public static void main(String[] args)throws Exception {
		//표준 입출력 스트림
		//1차 스트림 객체 생성
		InputStream is = System.in;//콘솔로부터 데이터를 입력받음
		//2차 보조 스트림을 이용해서 reader객체 생성
		Reader reader = new InputStreamReader(is);
		//InputStreamReader은 인풋스트림객체를 리더객체로 바꿔준다.
		//똑같은 방식의 출력용은 OutputStreamWriter이 있다.
		int read = 0;
		String str = "";
		char[] buf = new char[88];
		while((read = reader.read(buf)) != -1) {
			str = new String(buf, 0, read);
			System.out.println(str);
		}
		reader.close();
		/*while((read = is.read()) != -1) {
			System.out.write(read);
		}*/
	}

}

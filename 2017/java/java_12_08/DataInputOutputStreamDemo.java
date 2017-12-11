package java_12_08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamDemo {

	public static void main(String[] args) throws Exception{
		//1차 스트림 생성
		FileOutputStream fos = new FileOutputStream("C:/Users/user/Desktop/javaFile/test.dat");
		//2차 보조스트림에 넣어준다.
		DataOutputStream dos = new DataOutputStream(fos);
		//데이터를 기본데이터형대로 입출력 기능을 제공 바이너리형으로 데이터를 저장하기 때문에
		//파일을 직접보려고 하면 확인 불가능 읽을때도 저장할때 성격대로 읽어야함
		dos.writeUTF("호날두");
		dos.writeDouble(50.0);
		dos.writeInt(7);
				
		dos.flush();
		dos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Users/user/Desktop/javaFile/test.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println(dis.readUTF() + "선수는 평균 " + dis.readDouble() + 
							"골을 기록하고 등번호가 " + dis.readInt() + "번 이었다.");
		dis.close();
		fis.close();
	}
}

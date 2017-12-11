package java_12_08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutInputDemo {

	public static void main(String[] args) throws Exception {
		//Serializable를 인터페이스한 클래스만이 객체 저장이 가능하다.
		FileOutputStream fos = new FileOutputStream("C:/Users/user/Desktop/javaFile/obTest.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		FbData fd = new FbData();
		fd.name = "박지성";
		fd.num = 13;
		fd.team = "맨유";
		oos.writeObject(fd);
		oos.flush(); oos.close(); fos.close();	
		
		FileInputStream fis = new FileInputStream("C:/Users/user/Desktop/javaFile/obTest.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		FbData fdp = (FbData) ois.readObject();
		System.out.println(fdp.name + "선수는 " + fdp.team + "팀에서 " + 
							fdp.num + "번호로 뛰었다.");
		ois.close(); fis.close();

	}

}

class FbData implements Serializable{
	public String name;
	public int num;
	public String team;
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();//본인의 객체데이터를 전부 아웃풋 스트림에 넣어 작성
		//만약에 부모클래스의 변수가 있었다면 그건 따로 저장해줘야한다
		//ex) oos.writeInt(gool);
	}
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();//마찬가지로 부모 데이터가 있다면 따로 설정해야한다.
	}
}

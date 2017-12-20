package java_12_11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableDemo {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Users/user/Desktop/javaFile/obj.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		FbData fd = new FbData();
		fd.name = "박지성";
		fd.num = 13;
		fd.team.teamName = "맨유";
		fd.goal = 15;
		oos.writeObject(fd);
		oos.flush();	oos.close(); fos.close();	
		
		FileInputStream fis = new FileInputStream("C:/Users/user/Desktop/javaFile/obj.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		//여기서 serialVersionUID값의 비교가 일어남 수동으로 설정 가능
		FbData fd2 = (FbData) ois.readObject();
		System.out.println("선수: " + fd2.name);
		System.out.println("등번호: " + fd2.num);
		System.out.println("팀명: " + fd2.team.teamName);
		System.out.println("골수: " + fd2.goal);
	}

}
/*
	serialVersionUID 필드
	자바 파일은 컴파일러를 통해 클래스 파일이 될때 serialVersionUID가 부여되고 이를통해 객체가
	같은지 컴퓨터가 판단할 수 있다. 이는 파일로 객체를 저장할때도 마찬가지로 serialVersionUID를
	통해 같은 객체인지 구별이 되는대 serialVersionUID의 경우 클래스에 멤버가 추가된다던지
	변경이 생길경우 serialVersionUID값이 변하게 된다.
	그렇기 때문에 파일로 직렬화한 객체의 내용을 변경하게 된다면 serialVersionUID값이 달라
	역직렬화 역시 불가능하여 불러올수가 없다.
*/
class FbData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4492220409167422820L;
	//static final long serialVersionUID = 정수값;//serialVersionUID수동설정 가능
	//수동으로 serialVersionUID를 작업하는 이유는 클래스가 변경되면 역직렬화 과정에서
	//형변환 에러가 일어나기 때문에
	public String name;
	transient int num;
	//직렬화 대상에서 제외 즉 오브젝트를 파일로 만들때 보안상의 문제나 기타이유로 제외 할 때 사용
	//저장이 되지 않기 때문에 불러올때도 값이 없다. 즉 해당 클래스의 필요없는 멤버에 적용한다.
	FbTeam team = new FbTeam();
	static int goal;
}

class FbTeam implements Serializable{
	public String teamName;
}

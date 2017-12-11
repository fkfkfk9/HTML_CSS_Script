package java_12_06;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) throws Exception {
		//File클래스 : 파일과 폴더관련기능을 제공 C#의 경우 파일과 폴더를 관리하는 기능이 분리
		File f1 = new File("C:/Users/user/Desktop/javaFile"); 
		//폴더경로 폴더에 대한 작업을 하고싶을때
		File f2 = new File("C:/Users/user/Desktop/javaFile/filetest.txt");
		File f3 = new File("C:/Users/user/Desktop/javaFile/filetest2.txt");
		
		File f4 = new File(new URI("file:///C:/Users/user/Desktop/javaFile/filetest3.txt"));
				
		if(f1.exists() == false) {  f1.mkdirs();  }//경로에 폴더가 없을때 폴더 생성
		//mkdirs는 없는 경로에 있는 폴더를 모두 생성 mkdir은 하나만 생성한다.
		if(f2.exists() == false) {  f2.createNewFile();  }//경로에 파일이 없을때 생성
		if(f3.exists() == false) {  f3.createNewFile();  }
		if(f4.exists() == false) {  f4.createNewFile();  }

		File file = new File("C:/Users/user/Desktop/javaFile");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일   a   HH시mm분");
		File[] files = file.listFiles();//해당 폴더의 파일들을 배열화
		System.out.println("       날짜                   시간         형태              크기             이름");
		System.out.println("-------------------------------------------------------------------");
		for(File f : files) {
			System.out.print(sdf.format(new Date(f.lastModified())));
			//해당 파일의 마지막 업데이트 출력
			if(f.isDirectory()) {//배열상 f변수가 폴더인가 판단.0
				System.out.print("\t<DIR>\t\t\t" + f.getName());
			} else {
				System.out.print("\t\t\t" + f.length() + "\t" + f.getName());
			}
 			System.out.println();
		}
	}

}

package java_12_08;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputDemo {

	public static void main(String[] args)throws Exception {
		long startTime = 0;
		long endTime = 0;
		//버퍼보조스트림을 사용 안함
		FileInputStream fs = new FileInputStream("D:/YooJongHyun/fkfkfk9.github.io/img/header_img.jpg");
		startTime = System.currentTimeMillis();
		while(fs.read()!=-1) {}
		endTime = System.currentTimeMillis();
		System.out.println("버퍼 보조스트림 미사용시 "+(endTime-startTime));
		fs.close();
		//버퍼 보조스트림을 사용
		FileInputStream fs2 = new FileInputStream("D:/YooJongHyun/fkfkfk9.github.io/img/header_img.jpg");
		BufferedInputStream bis = new BufferedInputStream(fs2);
		startTime = System.currentTimeMillis();
		while(bis.read()!=-1) {}
		endTime = System.currentTimeMillis();
		System.out.println("버퍼 보조스트림 사용시 "+(endTime-startTime));
		bis.close();
		fs2.close();
		/* Decorator pattern 마치 장식하는 것처럼 보조스트림을 올리고 올려서 사용하는 패턴 */
	}

}

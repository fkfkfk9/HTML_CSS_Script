package java_11_17;

import java.text.MessageFormat;

public class MessageFormatDemo {

	public static void main(String[] args) {
		String msg = "이름: {0} \n학번: {1} \n학과: {2} \n전화: {3}";

		Object[] arguments = {
				"유종현","20071888", "모바일 소프트웨어", "010-4590-5395"
		};

		String mf = MessageFormat.format(msg, arguments);
		System.out.println(mf);
		Object[][] arguments2 = {
				{"유종현","20071888", "모바일 소프트웨어", "010-4590-5395"},
				{"홍길동","20079999", "컴퓨터공학", "123-456-7890"}
		};
		String tableName = "ST_INFO";
		String iMsg = "INSERT INTO "+ tableName +" VALUES (''{0}'',''{1}'',{2},''{3}'');";
		//VALUES값안에 데이터를 ''로 감싸야 하는대 언어에선'를 입력해선 인식이 안되므로 ''를 입력하여 '을 표시한다.
		for(int i=0; i < arguments2.length;i++) {
			String mf2 = MessageFormat.format(iMsg, arguments2[i]);
			System.out.println(mf2);
		}
	}

}

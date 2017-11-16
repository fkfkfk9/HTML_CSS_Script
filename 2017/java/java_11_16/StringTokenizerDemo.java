package java_11_16;
import java.util.*;

public class StringTokenizerDemo {//일정한 구분자를 기준으로 문자열을 잘라냄 split와유사
	//split는 ""같이 빈것도 배열에 추가하고 StringTokenizer은 추가하지 않는다.
	//주의사항으로 " "같은 공백문자가 있는것은 StringTokenizer도 포함된다.
	//즉 널값은 StringTokenizer에 포함되지 않고 split는 널값도 하나의 값으로 배열에 넣는다.
	public static void main(String[] args) {
		String str = "타이타닉, 반지의제왕, 해리포터";
		String str2 = "(타이타닉, 반지의제왕) +  [해리포터]";
		String[] splitArr = str.split(", ");//정규표현식 사용가능
		//리턴값이 스트링배열 매개변수를 기준으로 문자열을 잘라 배열화
		StringTokenizer st = new StringTokenizer(str, ", ");
		StringTokenizer st2 = new StringTokenizer(str2, "(,)+[] ", false);
		//구분자에서 ,뿐 아니라 제외하고픈 여러가지 기호를 다 넣어도 된다.
		//생성자 메서드의 3번째 매개변수의 기능
		//true : 2번째 매개변수로 지정된 구분자도 토큰처리를 한다.
		//false : 토큰에서 제외한다.
		while(st.hasMoreTokens()) {//더 이상 읽을 데이터가 없으면 펄스
			System.out.println(st.nextToken());//다음 데이터 출력
		}		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		for (String s : splitArr) {
			System.out.println(s);
		}
	}

}

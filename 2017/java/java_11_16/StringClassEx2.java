package java_11_16;

import java.util.StringJoiner;

public class StringClassEx2 {

	public static void main(String[] args) throws Exception {//문자 인코딩 변환시 예외처리
		String foods = "라면,김밥,떡볶이";
		//String[] arr = {"라면","김밥","떡볶이"}; 과 같다.
		String[] arr = foods.split(",");//리턴이 스트링 배열 인스턴스 메소드
		//split는 ,를 기준으로 문자열을 나눠 배열에 저장해줌
		System.out.println(String.join(" + ", arr));
		//객체를 만들지 않고 사용하기 때문에 join은 스테틱 메서드
		//문자열들 사이에 적어놓은 문자열을 넣어서 출력해줌
		//join의 두번째 매개변수의 ...은 가변인수로 1~무한으로 넣어줄 수 있다.
		
		//문자열을 결합하는 기능
		StringJoiner sj = new StringJoiner(", ", "(", ")");
		//첫번째 매개변수를 문자사이에 배치하고 2,3번째 매개변수로 감싼다.
		for (String string : arr) {
			sj.add(string);
		}
		System.out.println(sj);//그대로 객체명으로 출력
		String ar1 = String.valueOf(arr[0].charAt(1));
		//+ 연산자로 char형이나 정수형 데이터를 String으로 만들수도 있지만
		//String.valueOf를 이용하여 바꿔줄 수 있다.
		String ar0 = "" + arr[0].charAt(0);
		byte[] bArr  = ar0.getBytes("UTF-8");//getBytes : 문자 인코딩 변환
		//UTF-8는 한글을 3바이트로 표시
		byte[] bArr2 = ar0.getBytes("CP949");//매개변수로 넣은 방식으로 변환시킴
		//CP949는 한글을 2바이트로 표시
		StringJoiner sj2 = new StringJoiner(":", "[", "]");
		StringJoiner sj3 = new StringJoiner(":", "[", "]");
		for(byte b : bArr)
			sj2.add(String.format("%2X",b));//X는 16진수를 의미
		for(byte b : bArr2)
			sj3.add(String.format("%2X",b));

		System.out.println("UTF-8:" + sj2);
		System.out.println("CP949:" + sj3);

		System.out.println("UTF-8:" + new String(bArr,  "UTF-8"));
		//다시 원래 문자열로 인코딩하는법
		System.out.println("CP949:" + new String(bArr2, "CP949"));
		String iStr = "200";
		int is = Integer.parseInt("-" + "200");//+나 -를 넣으므로 양수나 음수로 넣을수 있다.
		System.out.println(is);
	}

}

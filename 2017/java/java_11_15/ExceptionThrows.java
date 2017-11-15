package java_11_15;

public class ExceptionThrows {

	public static void main(String[] args) {
		try {
			except();
		} catch (Exception e) {
			System.out.println("except2에서 예외 발생");
		}		
	}

	static void except() throws Exception{
		//예외가 넘어갔기 때문에 처리를 하던가 main으로 날려보내던가 선택해야한다.
		//둘다 처리하지 않을 경우 에러가 나서 컴파일이 불가능하다.
		except2();
	}
	static void except2() throws Exception{
		//원래는 예외를 발생시키면 거기서 try catch로 잡아야 하지만
		//예외처리를 안하고 불러온 곳으로 예외를 넘겨준다.
		//메소드 정의할떄 이름옆에 throws를 넣어준다.
		throw new Exception();//강제 예외 발생시키기
	}
}

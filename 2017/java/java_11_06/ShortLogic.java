package java_11_06;

public class ShortLogic {

	static boolean methodA() {
		System.out.println("methodA() 실행");
		return true;
	}
	static boolean methodB() {
		System.out.println("methodB() 실행");
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(methodA() == true && methodB() == true) {
			
		}
	}

}

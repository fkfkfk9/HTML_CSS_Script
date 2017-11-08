package java_11_08;

public class arrArgs {

	public static void main(String[] args) {
		/*
		 	메인 메소드에서 아규먼트를 이용하려면 일반적으로 런을 할께 아니라
		 	런 컨피규레이션을 통해 아규먼트를 입력해주고 실행해야 한다.
		*/
		if(args.length==0) {//아규먼트를 입력하지 않았을시 실행하는 구문
			System.out.println("아규먼트를 저장되어 있지 않습니다.");
			System.exit(0);//시스템을 종료시켜준다.
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}		
	}

}

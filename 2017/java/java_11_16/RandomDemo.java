package java_11_16;

public class RandomDemo {

	public static void main(String[] args) {
		System.out.println(Math.random());
		System.out.println((int)(Math.random()*10));
		//0~9
		System.out.println((int)(Math.random()*10+1));
		//1~10
		int min = 5;
		int max = 6;
		
		int random;
		
		random = min + (int)(Math.random()*max);
		
		System.out.println(random);
	}

}

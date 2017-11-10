package java_11_09;

public class ColorEx {

	public static void main(String[] args) {
		Color co = new Color();
		System.out.println("변경 전");
		co.printColor();
		
		co.red = "red";
		co.yellow = "yellow";
		co.blue = "blue";
		
		co.red = "빨강";
		co.yellow = "노랑";
		co.blue = "파랑";
		
		System.out.println("변경 후");
		co.printColor();
	}

}

class Color{
	String red;
	String yellow;
	String blue;	
	
	public void printColor() {
		System.out.printf("red : %s, yellow = %s, blue = %s \n", red, yellow, blue);
	}
}

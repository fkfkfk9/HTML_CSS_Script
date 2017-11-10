package java_11_09;

public class ColorArr {

	public static void main(String[] args) {
		Color[] coArr = new Color[3];
		
		System.out.println("변경 전");
		for (int i = 0; i < coArr.length; i++) {
			coArr[i] = new Color();
			coArr[i].red = "red" + (i+1);
			coArr[i].yellow = "yellow" + (i+1);
			coArr[i].blue = "blue" + (i+1);
			System.out.print("coArr[" + i + "] : ");
			coArr[i].printColor();
		}
		System.out.println("변경 후");
		for (int i = 0; i < coArr.length; i++) {
			coArr[i].red = "빨강" + (i+1);
			coArr[i].yellow = "노랑" + (i+1);
			coArr[i].blue = "파랑" + (i+1);
			System.out.print("coArr[" + i + "] : ");
			coArr[i].printColor();
		}
	}

}

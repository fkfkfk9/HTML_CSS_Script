package java_11_06;

public class BitOper {

	public static void main(String[] args) { 
		int x = 0xAF;
		int y = 0xD;
		String compzero = "00000000";
		String tempX = compzero + Integer.toBinaryString(x);
		String tempY = compzero + Integer.toBinaryString(y);
		String orXY = compzero + Integer.toBinaryString(x|y);
		String andXY = compzero + Integer.toBinaryString(x&y);
		String xorXY = compzero + Integer.toBinaryString(x^y);
		String xorXYY = compzero + Integer.toBinaryString(x^y^y);
		System.out.println("x의 2진수 : " + tempX.substring(tempX.length()-8));
		System.out.println("y의 2진수 : " + tempY.substring(tempY.length()-8));
		System.out.println("x or y  : " + orXY.substring(orXY.length()-8));
		System.out.println("x and y : " + andXY.substring(andXY.length()-8));
		System.out.println("x xor y : " + xorXY.substring(xorXY.length()-8));
		System.out.println("x^y^y   : " + xorXYY.substring(xorXYY.length()-8));
	}	
}

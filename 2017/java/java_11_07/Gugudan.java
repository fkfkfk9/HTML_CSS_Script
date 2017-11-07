package java_11_07;

public class Gugudan {
	public static void main(String[] args) { 
		gugu gu = new gugu();
		gu.setDan(4);
		gu.guLoop();
	}
}

class gugu{
	int dan;
	int maxnum = 9;
	
	public void setDan(int num){
		this.dan = num;
	}
	public void guLoop() {
		for (int i = 1; i <= maxnum; i++) {
			this.guPrint(i, this.dan);
		}
	}
	public void guPrint(int num1, int num2){
		for (int i = 2; i <= num2; i++) {
			System.out.printf("%d x %d = %2d", i, num1, i*num1);
			if(i == num2) System.out.println();
			else System.out.print(" | ");
		}
	}
}

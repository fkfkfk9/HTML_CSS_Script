package java_11_17;

import java.text.ChoiceFormat;

public class ChoiceFormatDemo {

	public static void main(String[] args) {
		double[] cut = {60, 63, 67, 70, 73, 77, 80, 83, 87, 90, 93, 97};
		// ChoiceFormat은 더블값만 가능 낮은 값부터 큰 값의 순서로 적어야한다.
		String[] grades = {"D-", "D", "D+", "C-", "C", "C+",
						   "B-", "B", "B+", "A-", "A", "A+"};
		//두 값이 갯수가 같아야 한다.
		int[] scores = { 100, 95, 88, 80, 52, 60, 70, 77, 66, 62, 98, 91};

		ChoiceFormat cf = new ChoiceFormat(cut, grades);

		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]+":"+cf.format(scores[i]));		
		}
		/*
			60#D : limit#value
			60#D|70#C|80<B|90#A : 60~69 가 D가된다 70~80까지C가된다.
			81~89까지 B가된다. 쯕 본인을 보함 안시킴
		*/
		String pattern = "60#D|70#C|80<B|90#A";
		ChoiceFormat cf2 = new ChoiceFormat(pattern);
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]+":"+cf2.format(scores[i]));		
		}
	}

}

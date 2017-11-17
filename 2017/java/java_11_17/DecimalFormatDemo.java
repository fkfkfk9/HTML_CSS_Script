package java_11_17;
import java.text.*;//java.time : jdk1.8부터 날짜, 시간, 형식화 관련 클래스 제공

public class DecimalFormatDemo {

	public static void main(String[] args) throws Exception{
		double dNum = 881103.11;
		/*단일로 쓸때 형식화해준다.
			double dNum = 881103.11;
			DecimalFormat df = new DecimalFormat("######.###");
			df.format(dNum);
		*/
		String[] decFormat = {
				"0","#","0.0","#.#","0000000000.0000","##########.####",
				"#.#-",	"-#.#","#,###.#","#,####.##","#E0","0E0","##E0",
				"00E0","####E0","0000E0","#.#E0","0.0E0","0.000000000E0",
				"00.00000000E0","000.0000000E0","#.#########E0",
				"##.########E0","###.#######E0","#,###.##+;#,###.##-",
				"#.#%","#.#\u2030",	"\u00A4 #,###","'#'#,###","''#,###", };
		for (int i = 0; i < decFormat.length; i++) {
			DecimalFormat df = new DecimalFormat(decFormat[i]);
			System.out.println(decFormat[i] + " : " + df.format(dNum));
		}
	}

}

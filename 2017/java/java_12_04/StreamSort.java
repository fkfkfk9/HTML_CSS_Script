package java_12_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class StreamSort {

	public static void main(String[] args) {
		int[] arr = {33,8,13,7,38,3};
		IntStream is = Arrays.stream(arr);
		is.sorted().forEach(System.out::println);
		ArrayList<FbPlayer> al  = new ArrayList<>();
		al.add(new FbPlayer("박지성", 13, 10));
		al.add(new FbPlayer("손흥민", 7, 22));
		al.add(new FbPlayer("호날두", 7, 50));
		al.add(new FbPlayer("데헤아", 1, 0));
		al.stream().sorted(Comparator.comparing(FbPlayer::getGoal))
		.forEach(fp->System.out.println(fp.getName() +
									" : " + fp.getGoal()));
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		List<Integer> results = new ArrayList<>();
		if (x <= y) {
			results.add(y - x);
		}
		if (-x <= y) {
			results.add(y - -x + 1);
		}
		if (x <= -y) {
			results.add(-y - x + 1);
		}
		if (-x <= -y) {
			results.add(-y - -x + 2);
		}

		System.out.println(results.stream().min(Integer::compareTo).get());
	}
}

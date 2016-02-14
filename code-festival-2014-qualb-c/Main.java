import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp1 = sc.nextLine();
		Map<Integer, Long> S1 =
			temp1.chars().boxed()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		String temp2 = sc.nextLine();
		Map<Integer, Long> S2 =
			temp2.chars().boxed()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		char[] S3 = sc.nextLine().toCharArray();

		int length1 = temp1.length();
		int length2 = temp2.length();
		int half = length1 / 2;

		OuterLoop: for (int c : S3) {
			if (length1 > half) {
				Long count = S1.get(c);
				if (count != null && count > 0) {
					S1.put(c, count - 1);
					length1--;
					continue OuterLoop;
				}
			}
			if (length2 > half) {
				Long count = S2.get(c);
				if (count != null && count > 0) {
					S2.put(c, count - 1);
					length2--;
					continue OuterLoop;
				}
			}

			// System.err.println(S1);
			// System.err.println(S2);
			// System.err.println(c);
			System.out.println("NO");
			return;
		}

		System.out.println("YES");
	}
}

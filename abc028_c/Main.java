import static java.util.Comparator.reverseOrder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] N = new int[] {
			sc.nextInt(),
			sc.nextInt(),
			sc.nextInt(),
			sc.nextInt(),
			sc.nextInt()
		};

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (i != j && j != k && i != k) {
						set.add(N[i] + N[j] + N[k]);
					}
				}
			}
		}

		int[] array =
			set.stream()
				.sorted(reverseOrder())
				.mapToInt(i -> i)
				.toArray();

		System.out.println(array[2]);
	}
}
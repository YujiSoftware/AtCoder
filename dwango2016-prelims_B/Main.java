import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] pair = new Pair[N - 1];
		for (int i = 0; i < N - 1; i++) {
			pair[i] = new Pair(i, sc.nextInt());
		}

		Arrays.parallelSort(pair, Comparator.comparing(p -> p.value));

		int[] result = new int[N];

		for (int i = 0; i < N - 1; i++) {
			int left = pair[i].key;
			int right = pair[i].key + 1;

			if (result[left] == 0) {
				result[left] = pair[i].value;
			}
			if (result[right] == 0) {
				result[right] = pair[i].value;
			}
		}

		System.out.println(
			String.join(" ",
				IntStream.of(result).mapToObj(Integer::toString).collect(Collectors.toList())));
	}

	public static class Pair {
		public int key;
		public int value;

		public Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}

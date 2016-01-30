import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] A = new Pair[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = new Pair(i, sc.nextInt());
		}

		TreeMap<Integer, List<Pair>> collect =
			Stream.of(A)
				.collect(Collectors.groupingBy(Pair::getValue, TreeMap::new, Collectors.toList()));

		int count = 1;
		int prev = -1;
		for (Map.Entry<Integer, List<Pair>> entry : collect.entrySet()) {
			int[] keys =
				entry.getValue().stream()
					.mapToInt(Pair::getKey)
					.sorted()
					.toArray();

			int filter = prev;
			OptionalInt last =
				IntStream.of(keys)
					.filter(k -> k < filter)
					.reduce((a, b) -> b); // get last element

			if (last.isPresent()) {
				count++;
				prev = last.getAsInt();
			} else {
				prev = keys[keys.length - 1];
			}
		}

		if (prev == 0) {
			count--;
		}

		System.out.println(count);
	}

	public static class Pair {
		private int key;
		private int value;

		public Pair(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "{" + key + ", " + value + "}";
		}
	}
}

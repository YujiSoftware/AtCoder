import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
	public static void main(String[] args) throws IOException {
		List<Integer> prime = new ArrayList<>();
		try(Scanner sc = new Scanner(
				Files.newInputStream(Paths.get("R:\\素数.txt")))){
			prime.add(sc.nextInt());
		}
		
		final int LIMIT = 1000000000;

		List<Pair> list = IntStream.rangeClosed(0, 10000)
				.parallel()
				.mapToObj(i -> {
					int start = LIMIT / 10 - i;
					int pow = (int) Math.pow(i, 2);
					int count = 0;
					for (int j = 2; j < pow; j++) {
						if (start % j == 0) {
							count++;
						}
					}

					if (i % 100 == 0) {
						// System.out.println(start + "," + count);
						System.out.println(":" + i);
					}

					return new Pair(start, count);
				})
				.collect(Collectors.toList());

		Collections.sort(list, Comparator.comparing(Pair::getValue).reversed());

		int i = 0;
		for (Pair p : list) {
			i++;
			System.err.println(p.key);

			if (i > 100) {
				break;
			}
		}
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

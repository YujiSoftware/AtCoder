import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] box = new Pair[N];
		for (int i = 0; i < N; i++) {
			box[i] = new Pair(sc.nextInt(), sc.nextInt());
		}

		int height = getHeight(box);
		System.err.println();
		int width = getWidth(box);

		System.out.println(Math.max(height, width));
	}

	private static int getHeight(Pair[] box) {
		Map<Integer, List<Pair>> collect = Stream.of(box)
			.collect(Collectors.groupingBy(b -> b.getWidth()));
		List<Integer> keys = new ArrayList<>(collect.keySet());
		Collections.sort(keys);

		int length = 0;
		int height = -1;
		for (Integer key : keys) {
			List<Pair> list = collect.get(key);
			int limit = height;
			length++;

			Optional<Pair> pair = list.stream()
				.filter(b -> b.height > limit)
				.min(Comparator.comparing(b -> b.getHeight()));

			System.err.println(pair);

			if (pair.isPresent()) {
				height = pair.get().height;
			} else {
				break;
			}
		}

		return length;
	}

	private static int getWidth(Pair[] box) {
		Map<Integer, List<Pair>> collect = Stream.of(box)
			.collect(Collectors.groupingBy(b -> b.getHeight()));
		List<Integer> keys = new ArrayList<>(collect.keySet());
		Collections.sort(keys);

		int length = 0;
		int width = -1;
		for (Integer key : keys) {
			List<Pair> list = collect.get(key);
			int limit = width;

			Optional<Pair> pair = list.stream()
				.filter(b -> b.width > limit)
				.min(Comparator.comparing(b -> b.getWidth()));

			System.err.println(pair);

			if (pair.isPresent()) {
				length++;
				width = pair.get().width;
			} else {
				break;
			}
		}

		return length;
	}

	public static class Pair {
		private int width;
		private int height;

		public Pair(int width, int height) {
			super();
			this.width = width;
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public String toString() {
			return "{" + width + ", " + height + "}";
		}
	}

	public static class Scanner {
		private BufferedInputStream inputStream;

		public Scanner(InputStream in) {
			inputStream = new BufferedInputStream(in);
		}

		public int nextInt() throws IOException {
			int num = 0;

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			do {
				num = num * 10 + (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public int[] nextInt(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}

			return array;
		}

		public long nextLong() throws IOException {
			long num = 0;

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			do {
				num = num * 10 + (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public long[] nextLong(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextLong();
			}

			return array;
		}

		public String next() throws IOException {
			StringBuilder builder = new StringBuilder();

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			do {
				builder.append((char) read);
			} while ((read = inputStream.read()) > 0x20);

			return builder.toString();
		}
	}
}

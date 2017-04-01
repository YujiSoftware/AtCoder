import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			map.get(a).add(b);
			map.get(b).add(a);
		}

		int Q = sc.nextInt();
		int[] v = new int[Q];
		int[] d = new int[Q];
		int[] c = new int[Q];
		for (int i = 0; i < Q; i++) {
			int index = Q - i - 1;
			v[index] = sc.nextInt() - 1;
			d[index] = sc.nextInt();
			c[index] = sc.nextInt();
		}

		int[] colors = new int[N];
		int[] max = new int[N];
		Arrays.fill(max, -1);
		for (int i = 0; i < Q; i++) {
			Deque<Pair> queue = new ArrayDeque<>();
			queue.add(new Pair(v[i], d[i]));

			while (!queue.isEmpty()) {
				Pair p = queue.pop();
				if (max[p.key] < p.value) {
					max[p.key] = p.value;

					if (colors[p.key] == 0) {
						colors[p.key] = c[i];
					}

					if (p.value > 0) {
						for (Integer next : map.get(p.key)) {
							queue.add(new Pair(next, p.value - 1));
						}
					}
				}
			}
		}

		System.out.println(
				Arrays.stream(colors).mapToObj(Integer::toString).collect(Collectors.joining(System.lineSeparator())));
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
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

	public static class Scanner {
		private BufferedInputStream inputStream;

		public Scanner(InputStream in) {
			inputStream = new BufferedInputStream(in);
		}

		public int nextInt() throws IOException {
			int num = 0;
			int sign = 1;

			int read = skip();
			if (read == '-') {
				sign = -1;
				read = inputStream.read();
			}

			do {
				num = num * 10 + sign * (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public void fill(int[] a) throws IOException {
			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
			}
		}

		public void fill(int[] a, int[] b) throws IOException {
			if (a.length != b.length) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
				b[i] = nextInt();
			}
		}

		public void fill(int[] a, int[] b, int[] c) throws IOException {
			if (a.length != b.length || b.length != c.length) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
				b[i] = nextInt();
				c[i] = nextInt();
			}
		}

		public long nextLong() throws IOException {
			long num = 0;

			int read = skip();
			do {
				num = num * 10 + (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public void fill(long[] a) throws IOException {
			for (int i = 0; i < a.length; i++) {
				a[i] = nextLong();
			}
		}

		public void fill(long[] a, long[] b) throws IOException {
			if (a.length != b.length) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = nextLong();
				b[i] = nextLong();
			}
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

			int read = skip();
			do {
				builder.append((char) read);
			} while ((read = inputStream.read()) > 0x20);

			return builder.toString();
		}

		private int skip() throws IOException {
			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			return read;
		}
	}
}

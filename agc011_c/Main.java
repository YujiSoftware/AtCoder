import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] u = new int[M];
		int[] v = new int[M];
		for (int i = 0; i < M; i++) {
			u[i] = sc.nextInt() - 1;
			v[i] = sc.nextInt() - 1;
		}

		Map<Pair, List<Pair>> graph = new HashMap<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				Pair[][] pair = new Pair[4][];
				pair[0] = new Pair[] { new Pair(u[i], v[j]), new Pair(v[i], u[j]) };
				pair[1] = new Pair[] { new Pair(v[i], u[j]), new Pair(u[i], v[j]) };
				pair[2] = new Pair[] { new Pair(u[i], u[j]), new Pair(v[i], v[j]) };
				pair[3] = new Pair[] { new Pair(v[i], v[j]), new Pair(u[i], u[j]) };

				for (Pair[] p : pair) {
					List<Pair> list = graph.get(p[0]);
					if (list != null) {
						list.add(p[1]);
					} else {
						list = new ArrayList<>();
						list.add(p[1]);
						graph.put(p[0], list);
					}
				}
			}
		}

		Set<Pair> used = new HashSet<>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Pair start = new Pair(i, j);
				if (!used.contains(start)) {
					count++;

					Deque<Pair> queue = new ArrayDeque<>();
					queue.add(start);
					while (!queue.isEmpty()) {
						Pair current = queue.pop();
						if (used.contains(current)) {
							continue;
						}
						used.add(current);

						List<Pair> list = graph.get(current);
						if (list != null) {
							queue.addAll(list);
						}
					}
				}
			}
		}

		System.out.println(count);
	}

	public static class Pair {
		private int u;
		private int v;

		public Pair(int u, int v) {
			super();
			this.u = u;
			this.v = v;
		}

		public int getU() {
			return u;
		}

		public int getV() {
			return v;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + u;
			result = prime * result + v;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (u != other.u)
				return false;
			if (v != other.v)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "{" + (u + 1) + ", " + (v + 1) + "}";
		}
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}

	public static class Scanner {
		private BufferedInputStream inputStream;
		private StringBuilder buffer = new StringBuilder();

		public Scanner(InputStream in) {
			inputStream = new BufferedInputStream(in);
		}

		public int nextInt() throws IOException {
			int num = 0;

			int read = skip();
			do {
				num = num * 10 + (read - 0x30);
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
			int read = skip();
			do {
				buffer.append((char) read);
			} while ((read = inputStream.read()) > 0x20);

			String text = buffer.toString();
			buffer.delete(0, buffer.length());

			return text;
		}

		private int skip() throws IOException {
			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			return read;
		}
	}
}
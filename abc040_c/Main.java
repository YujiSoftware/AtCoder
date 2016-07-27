import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = sc.nextInt(N);

		Deque<Bar> queue = new ArrayDeque<>();
		queue.add(new Bar(0, 0));

		int min = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Bar bar = queue.poll();
			if (bar.now == N - 1) {
				if (bar.cost < min) {
					min = bar.cost;
				}
				continue;
			}

			for (int i = 0; i < 2; i++) {
				int next = bar.now + i + 1;
				if (next >= N) {
					break;
				}

				int cost = Math.abs(a[bar.now] - a[next]);
				queue.add(new Bar(bar.cost + cost, next));
			}
		}

		System.out.println(min);
	}

	private static class Bar implements Comparable<Bar> {
		public int cost;
		public int now;

		public Bar(int cost, int now) {
			this.cost = cost;
			this.now = now;
		}

		public int getCost() {
			return cost;
		}

		public int getNow() {
			return now;
		}

		@Override
		public int compareTo(Bar other) {
			return this.now - other.now;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Bar park = (Bar) o;

			if (cost != park.cost) return false;
			return now == park.now;

		}

		@Override
		public int hashCode() {
			int result = cost;
			result = 31 * result + now;
			return result;
		}

		@Override
		public String toString() {
			return "Bar{cost=" + cost + ", now=" + now + '}';
		}
	}

	public static class Scanner {
		private BufferedInputStream inputStream;

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

		public int[] nextInt(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}

			return array;
		}

		public long nextLong() throws IOException {
			long num = 0;

			int read = skip();
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

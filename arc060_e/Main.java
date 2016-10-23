import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	private static final int MATRIX_SIZE = 30;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] x = new int[N];
		sc.fill(x);
		int L = sc.nextInt();
		int Q = sc.nextInt();
		int[] a = new int[Q];
		int[] b = new int[Q];
		for (int i = 0; i < Q; i++) {
			a[i] = sc.nextInt() - 1;
			b[i] = sc.nextInt() - 1;
		}
		int[] next = new int[N];
		for (int i = 0; i < N; i++) {
			boolean found = false;
			for (int j = i + 1; j < N; j++) {
				if (x[j] - x[i] > L) {
					next[i] = j - 1;
					found = true;
					break;
				}
			}
			if (!found) {
				next[i] = N - 1;
			}
		}
		System.err.println(Arrays.toString(next));
		int[] prev = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			boolean found = false;
			for (int j = i - 1; j >= 0; j--) {
				if (x[i] - x[j] > L) {
					prev[i] = j + 1;
					found = true;
					break;
				}
			}
			if (!found) {
				prev[i] = 0;
			}
		}

		for (int i = 0; i < Q; i++) {
			int start = a[i];
			int end = b[i];

			int days = 0;
			if (start < end) {
				int index = start;
				while (index < end) {
					index = next[index];
					days++;
				}
			} else {
				int index = start;
				while (index > end) {
					index = prev[index];
					days++;
				}
			}

			System.out.println(days);
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

		public long nextLong() throws IOException {
			long num = 0;
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

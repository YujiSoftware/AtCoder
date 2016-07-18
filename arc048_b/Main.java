import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	private static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] R = new int[N];
		int[] H = new int[N];
		for (int i = 0; i < N; i++) {
			R[i] = sc.nextInt();
			H[i] = sc.nextInt();
		}

		int[] win = new int[N];
		int[] lose = new int[N];
		int[] even = new int[N];

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (R[i] > R[j]) {
					win[i]++;
					lose[j]++;
				} else if (R[i] < R[j]) {
					win[j]++;
					lose[i]++;
				} else {
					if (H[i] == H[j]) {
						even[i]++;
						even[j]++;
					} else {
						if (H[i] == 1 && H[j] == 2
								|| H[i] == 2 && H[j] == 3
								|| H[i] == 3 && H[j] == 1) {
							win[i]++;
							lose[j]++;
						} else {
							win[j]++;
							lose[i]++;
						}
					}
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < N; i++) {
			builder.append(win[i]);
			builder.append(' ');
			builder.append(lose[i]);
			builder.append(' ');
			builder.append(even[i]);
			builder.append(System.lineSeparator());
		}

		System.out.print(builder.toString());
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

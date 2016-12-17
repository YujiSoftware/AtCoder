import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		sc.fill(A);
		final int LIMIT = 4;

		boolean[] transited = new boolean[N];
		int[] count = new int[LIMIT + 1];
		for (int i = 0; i < N; i++) {
			count[A[i]]++;
		}

		int lift = 0;
		int index = 0;
		while (index < N) {
			if (!transited[index]) {
				int sum = A[index];
				count[A[index]]--;
				transited[index] = true;

				while (sum < LIMIT) {
					int max = -1;
					for (int i = 1; i <= LIMIT - sum; i++) {
						if (count[i] > 0) {
							max = i;
						}
					}
					if (max > -1) {
						for (int i = index + 1; i < N; i++) {
							if (A[i] == max && !transited[i]) {
								sum += max;
								count[max]--;
								transited[i] = true;
								break;
							}
						}
					} else {
						break;
					}
				}
				lift++;
			}
			index++;
		}

		System.out.println(lift);
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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] h = new int[N];
		sc.fill(h);

		h = Arrays.stream(h)
				.boxed()
				.sorted(Comparator.reverseOrder())
				.mapToInt(i -> i)
				.toArray();
		int diff = (A - B);
		int count = 0;

		boolean all = false;
		while (true) {
			if (!all) {
				int value = h.length;
				if (!all) {
					value = 1;
					int first = h[0];
					for (int i = 1; i < h.length; i++) {
						if (h[i] != first) {
							break;
						}
						value++;
					}
				}

				count += value;
				for (int i = 0; i < value; i++) {
					h[i] -= diff;
				}

				for (int i = 1; i < h.length; i++) {
					if (h[i - 1] <= h[i]) {
						int tmp = h[i - 1];
						h[i - 1] = h[i];
						h[i] = tmp;
					} else {
						break;
					}
				}

				if (h[0] == h[h.length - 1]) {
					all = true;
				}
			} else {
				h[0] -= diff;
				count += h.length;
			}
			if (h[0] - count * B <= 0) {
				break;
			}
		}

		System.out.println(count);
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
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
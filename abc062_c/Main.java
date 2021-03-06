import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long H = sc.nextInt();
		long W = sc.nextInt();
		int w1 = (int) Math.ceil(W / 3.0);
		long[] sizeW1 = {
				w1 * H,
				(W - w1) * (H / 2),
				(W - w1) * (H - (H / 2))
		};
		long diffW1 = max(sizeW1) - min(sizeW1);
		long[] sizeW3 = {
				w1 * H,
				w1 * H,
				(W - w1 * 2) * H
		};
		long diffW3 = max(sizeW3) - min(sizeW3);

		int w2 = (int) Math.floor(W / 3.0);
		long[] sizeW2 = {
				w2 * H,
				(W - w2) * (H / 2),
				(W - w2) * (H - (H / 2))
		};
		long diffW2 = max(sizeW2) - min(sizeW2);
		long[] size4 = {
				w2 * H,
				w2 * H,
				(W - w2 * 2) * H
		};
		long diffW4 = max(size4) - min(size4);

		int h1 = (int) Math.ceil(H / 3.0);
		long[] sizeH1 = {
				h1 * W,
				(H - h1) * (W / 2),
				(H - h1) * (W - (W / 2))
		};
		long diffH1 = max(sizeH1) - min(sizeH1);
		long[] sizeH3 = {
				h1 * W,
				h1 * W,
				(H - h1 * 2) * W
		};
		long diffH3 = max(sizeH3) - min(sizeH3);

		int h2 = (int) Math.floor(H / 3.0);
		long[] sizeH2 = {
				h2 * W,
				(H - h2) * (W / 2),
				(H - h2) * (W - (W / 2))
		};
		long diffH2 = max(sizeH2) - min(sizeH2);
		long[] sizeH4 = {
				h2 * W,
				h2 * W,
				(H - h2 * 2) * W
		};
		long diffH4 = max(sizeH4) - min(sizeH4);

		System.out.println(min(diffW1, diffW2, diffW3, diffW4, diffH1, diffH2, diffH3, diffH4));
	}

	private static long min(long... values) {
		Arrays.sort(values);
		return values[0];
	}

	private static long max(long... values) {
		Arrays.sort(values);
		return values[values.length - 1];
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

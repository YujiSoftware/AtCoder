import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int K = sc.nextInt();

		char[][] s = new char[H][];
		for (int i = 0; i < H; i++) {
			s[i] = sc.next().toCharArray();
		}

		boolean[][] used = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (s[i][j] == '0' || s[i][j] == '1') {
					used[i][j] = true;
				}
			}
		}

		Buffer buffer = new Buffer(K);
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				if (!used[y][x]) {
					int xx = x;
					int yy = y;

					boolean[][] cache = new boolean[H][];
					for (int i = 0; i < H; i++) {
						cache[i] = Arrays.copyOf(used[i], W);
					}

					int index = 0;
					int[] bufX = new int[K];
					int[] bufY = new int[K];
					bufX[index] = xx;
					bufY[index] = yy;
					cache[yy][xx] = true;
					index++;

					for (int i = 1; i < K; i++) {
						if (xx - 1 >= 0 && !cache[yy][xx - 1]) {
							xx--;
						} else if (xx + 1 < W && !cache[yy][xx + 1]) {
							xx++;
						} else if (yy + 1 < H && !cache[yy + 1][xx]) {
							yy++;
						} else if (yy - 1 >= 0 && !cache[yy - 1][xx]) {
							yy--;
						} else {
							break;
						}

						bufX[index] = xx;
						bufY[index] = yy;
						cache[yy][xx] = true;
						index++;
					}

					if (index == K) {
						for (int i = 0; i < K; i++) {
							buffer.push(bufY[i], bufX[i]);
						}
						for (int i = 0; i < H; i++) {
							used[i] = cache[i];
						}
						buffer.end();
					}
				}
			}
		}

		System.out.println(buffer);
	}

	private static class Buffer {
		private StringBuilder result = new StringBuilder();
		private int count = 0;
		private int k;

		public Buffer(int k) {
			this.k = k;
		}

		public void push(int y, int x) {
			result.append(y + 1).append(' ').append(x + 1).append(System.lineSeparator());
		}

		public void end() {
			count++;
		}

		public String toString() {
			return (count) + System.lineSeparator() + result;
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

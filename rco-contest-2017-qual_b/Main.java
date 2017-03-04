import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	private static int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int H = scanner.nextInt();
		int W = scanner.nextInt();
		int K = scanner.nextInt();
		int sr = scanner.nextInt() - 1;
		int sc = scanner.nextInt() - 1;
		char[][] s = new char[H][];
		for (int i = 0; i < H; i++) {
			s[i] = scanner.next().toCharArray();
		}
		int N = scanner.nextInt();
		int[] fr = new int[N];
		int[] fc = new int[N];
		int[] F = new int[N];
		int[] D = new int[N];
		for (int i = 0; i < N; i++) {
			fr[i] = scanner.nextInt() - 1;
			fc[i] = scanner.nextInt() - 1;
			F[i] = scanner.nextInt();
			D[i] = scanner.nextInt();
		}

		boolean[][] used = new boolean[H][W];
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				if (s[y][x] == '#') {
					used[y][x] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder(K);
		int x = sc;
		int y = sr;
		for (int i = 0; i < K; i++) {
			int nx = x;
			int ny = y;
			char nc = '\0';
			if (y - 1 >= 0 && !used[y - 1][x]) {
				ny--;
				nc = 'U';
			} else if (x - 1 >= 0 && !used[y][x - 1]) {
				nx--;
				nc = 'L';
			} else if (y + 1 < W && !used[y + 1][x]) {
				ny++;
				nc = 'D';
			} else if (x + 1 < H && !used[y][x + 1]) {
				nx++;
				nc = 'R';
			}

			if (nc == '\0') {
				break;
			}

			sb.append(nc);
			used[ny][nx] = true;

			x = nx;
			y = ny;
		}

		for (int i = sb.length(); i < K; i++) {
			sb.append('-');
		}

		System.out.println(sb);
	}

	private static class Position {
		public int x;
		public int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
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

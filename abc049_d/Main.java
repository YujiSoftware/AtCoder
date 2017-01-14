import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int L = sc.nextInt();
		int[][] road = new int[N][N];
		int[][] train = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(road[i], 100);
			Arrays.fill(train[i], 100);
		}
		for (int i = 0; i < N; i++) {
			road[i][i] = 0;
			train[i][i] = 0;
		}

		for (int i = 0; i < K; i++) {
			int p = sc.nextInt() - 1;
			int q = sc.nextInt() - 1;
			road[p][q] = 0;
			road[q][p] = 0;
		}
		for (int i = 0; i < L; i++) {
			int r = sc.nextInt() - 1;
			int s = sc.nextInt() - 1;
			train[r][s] = 0;
			train[s][r] = 0;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					road[j][k] = Math.min(road[j][k], road[j][i] + road[i][k]);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					train[j][k] = Math.min(train[j][k], train[j][i] + train[i][k]);
				}
			}
		}

		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (road[i][j] == 0 && train[i][j] == 0) {
					result[i]++;
				}
			}
		}

		System.out.println(Arrays.stream(result).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
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

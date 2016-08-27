import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		int A = sc.nextInt();
		AddQuery[] add = new AddQuery[A];
		for (int i = 0; i < A; i++) {
			add[i] = new AddQuery(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
		}
		int B = sc.nextInt();
		InfoQuery[] info = new InfoQuery[B];
		for (int i = 0; i < B; i++) {
			info[i] = new InfoQuery(i, sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1);
		}

		int[][] array = new int[add.length + 1][N];
		array[0] = a;

		for (int i = 0; i < add.length; i++) {
			array[i + 1] = Arrays.copyOf(array[i], array[i].length);

			for (int j = add[i].L; j <= add[i].R; j++) {
				array[i + 1][j] += add[i].X;
			}
		}

		for (InfoQuery in : info) {
			int min = Integer.MAX_VALUE;
			for (int i = in.S; i <= in.T + 1; i++) {
				min = Math.min(min, array[i][in.K]);
			}
			System.out.println(min);
		}

		return;
	}

	private static class AddQuery {
		public int L;
		public int R;
		public int X;

		public AddQuery(int L, int R, int X) {
			this.L = L;
			this.R = R;
			this.X = X;
		}
	}

	private static class InfoQuery {
		public int index;
		public int S;
		public int T;
		public int K;

		public InfoQuery(int index, int S, int T, int K) {
			this.index = index;
			this.S = S;
			this.T = T;
			this.K = K;
		}

		public int getIndex() {
			return index;
		}

		public int getS() {
			return S;
		}

		public int getT() {
			return T;
		}

		public int getK() {
			return K;
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

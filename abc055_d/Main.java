import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	private static boolean check(char left, char center, char right, char c) {
		if (left == right) {
			if (center == 'S' && c == 'o') {
				return true;
			} else if (center == 'W' && c == 'x') {
				return true;
			}
		} else {
			if (center == 'S' && c == 'x') {
				return true;
			} else if (center == 'W' && c == 'o') {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] s = sc.next().toCharArray();

		char[] answer = new char[N];
		answer[0] = answer[1] = 'S';
		for (int i = 1; i < N - 1; i++) {
			char left = answer[i - 1];

			boolean reverse = false;
			if (answer[i] == 'S') {
				reverse = (s[i] != 'o');
			} else {
				reverse = (s[i] != 'x');
			}

			if (reverse) {
				answer[i] = left == 'S' ? 'W' : 'S';
			}
		}

		char[][] ans = new char[4][];
		ans[0] = Arrays.copyOf(answer, answer.length);
		ans[0][0] = 'S';
		ans[0][N - 1] = 'S';
		ans[1] = Arrays.copyOf(answer, answer.length);
		ans[1][0] = 'S';
		ans[1][N - 1] = 'W';
		ans[2] = Arrays.copyOf(answer, answer.length);
		ans[2][0] = 'W';
		ans[2][N - 1] = 'S';
		ans[3] = Arrays.copyOf(answer, answer.length);
		ans[3][0] = 'W';
		ans[3][N - 1] = 'W';

		for (char[] a : ans) {
			boolean ok = true;
			ok &= check(a[N - 2], a[N - 1], a[0], s[N - 1]);
			ok &= check(a[N - 1], a[0], a[1], s[0]);

			if (ok) {
				System.out.println(a);
				return;
			}
		}

		System.out.println("-1");
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
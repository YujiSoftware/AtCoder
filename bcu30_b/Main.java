import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[][] s = new char[9][];
		for (int i = 0; i < 9; i++) {
			s[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < 9; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char c = s[i][j];
				if (set.contains(c)) {
					System.out.println("No");
					return;
				}
				set.add(c);
			}
		}
		for (int i = 0; i < 9; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char c = s[j][i];
				if (set.contains(c)) {
					System.out.println("No");
					return;
				}
				set.add(c);
			}
		}

		int[][] patterns = new int[][] {
				new int[] { -2, -1 },
				new int[] { -2, +1 },
				new int[] { -1, -2 },
				new int[] { -1, +2 },
				new int[] { +1, -2 },
				new int[] { +1, +2 },
				new int[] { +2, -1 },
				new int[] { +2, +1 },
		};

		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				char c = s[y][x];
				for (int[] pattern : patterns) {
					if (c == GetValue(s, y + pattern[0], x + pattern[1])) {
						System.out.println("No");
						return;
					}
				}
			}
		}

		System.out.println("Yes");
	}

	private static char GetValue(char[][] board, int y, int x) {
		if (y < 0 || y >= 9 || x < 0 || x >= 9) {
			return '\0';
		}

		return board[y][x];
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

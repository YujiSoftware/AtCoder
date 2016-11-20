import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	private static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int K = sc.nextInt();

		int[][] board = new int[H][W + 1];
		for (int i = 0; i < H; i++) {
			char[] chars = sc.next().toCharArray();
			for (int j = 0; j < chars.length; j++) {
				board[H - i - 1][j] = chars[j] - '0';
			}
			board[H - 1 - 1][W] = 0;
		}

		long score = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				score = Math.max(score, getScore(board, K, i, j));
			}
		}

		System.out.println(score);
	}

	private static void drop(int[][] board) {
		int[] now = new int[board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boolean found = false;
				for (int k = now[j]; k < board.length; k++) {
					if (board[k][j] != -1) {
						now[j] = k;
						found = true;
						break;
					}
				}

				if (found) {
					board[i][j] = board[now[j]][j];
					now[j]++;
				} else {
					board[i][j] = 0;
				}
			}
		}
	}

	private static void debug(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.err.println(Arrays.toString(board[i]));
		}
		System.err.println();
	}

	private static long getScore(int[][] source, int minLength, int y, int x) {
		int[][] board = new int[source.length][];
		for (int i = 0; i < source.length; i++) {
			board[i] = Arrays.copyOf(source[i], source[i].length);
		}

		board[y][x] = -1;
		drop(board);

		int step = 0;
		long score = 0;
		while (true) {
			boolean found = false;

			int sum = 0;
			for (int i = 0; i < board.length; i++) {
				int prev = board[i][0];
				int length = 1;
				for (int j = 1; j < board[i].length; j++) {
					if (prev != 0 && prev == board[i][j]) {
						length++;
					} else {
						if (length >= minLength) {
							found = true;
							sum += prev * length;
							Arrays.fill(board[i], j - length, j, -1);
						}
						prev = board[i][j];
						length = 1;
					}
				}
			}

			score += Math.pow(2, step) * sum;
			step++;

			if (!found) {
				break;
			}

			drop(board);
		}

		return score;
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

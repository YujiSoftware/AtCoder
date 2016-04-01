import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] left = new int[Q];
		int[] right = new int[Q];
		for (int i = 0; i < Q; i++) {
			left[i] = sc.nextInt();
			right[i] = sc.nextInt();
		}

		boolean[] board = new boolean[N];
		for (int i = 0; i < Q; i++) {
			board[left[i] - 1] = !board[left[i] - 1];

			if (right[i] < N) {
				board[right[i]] = !board[right[i]];
			}
			// print(board, System.err);
		}

		print(board, System.out);
	}

	private static void print(boolean[] board, PrintStream out) {
		boolean now = false;
		for (int i = 0; i < board.length; i++) {
			if (board[i]) {
				now = !now;
			}
			out.print(now ? 1 : 0);
		}

		out.println();
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

		public int[] nextInt(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}

			return array;
		}

		public long nextLong() throws IOException {
			long num = 0;

			int read = skip();
			do {
				num = num * 10 + (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
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

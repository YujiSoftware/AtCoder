import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = 100;
		int[][] A = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				A[y][x] = sc.nextInt();
			}
		}

		long score = 0;
		int[][] output = new int[N][N];
		Random random = new SecureRandom();

		long startTime = System.currentTimeMillis();
		int count = 0;
		do {
			Board board = new Board(N);
			int[][] temp = new int[N][N];

			boolean[][] used = new boolean[N][N];
			Cell[] next = new Cell[1500];
			int index = 0;
			while (index < next.length) {
				int x = random.nextInt(N);
				int y = random.nextInt(N);
				if (used[y][x]) {
					continue;
				}

				next[index++] = new Cell(x, y, A[y][x]);
				used[y][x] = true;
			}

			int loop = 0;
			for (Cell cell : next) {
				int diff = A[cell.y][cell.x] - board.getValue(cell.x, cell.y);
				int value = Math.min(N - 18, diff / 18);
				if (value <= 0) {
					continue;
				}

				board.setValue(cell.x, cell.y, value);
				temp[cell.y][cell.x] += value;

				if (++loop == 1000) {
					break;
				}
			}

			long newScore = calcScore(A, board.board);
			if (score < newScore) {
				score = newScore;
				output = temp;
			}

			count++;
		} while (System.currentTimeMillis() - startTime <= 5650);

		output(output);
		debug(count);
	}

	private static long calcScore(int[][] begin, int[][] current) {
		long sum = 0;
		for (int i = 0; i < begin.length; i++) {
			for (int j = 0; j < current.length; j++) {
				sum += Math.abs(begin[i][j] - current[i][j]);
			}
		}

		return 200_000_000 - sum;
	}

	public static void output(int[][] board) {
		PriorityQueue<Cell> queue = new PriorityQueue<Cell>(Comparator.comparing(Cell::getValue).reversed());
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				queue.add(new Cell(x, y, board[y][x]));
			}
		}

		StringBuilder builder = new StringBuilder();
		int count = 0;
		for (int i = 0; i < 1000; i++) {
			Cell cell = queue.poll();
			if (cell.value <= 0) {
				break;
			}
			count++;

			builder.append(cell.x)
					.append(' ')
					.append(cell.y)
					.append(' ')
					.append(cell.value)
					.append(System.lineSeparator());

		}

		System.out.println(count);
		System.out.println(builder.toString());
	}

	public static class Board {
		int N;
		int[][] board;

		public Board(int N) {
			this.N = N;
			this.board = new int[N][N];
		}

		public void setValue(int X, int Y, int value) {
			int yLimit = Math.min(Y + value, N);
			int xLimit = Math.min(X + value, N);

			for (int y = Math.max(0, Y - value + 1); y < yLimit; y++) {
				int diffY = Math.abs(y - Y);
				for (int x = Math.max(0, X - value + 1); x < xLimit; x++) {
					int diffX = Math.abs(x - X);
					board[y][x] += Math.max(0, value - diffX - diffY);
				}
			}
		}

		public int getValue(int x, int y) {
			return board[y][x];
		}

		public String toString() {
			StringBuilder builder = new StringBuilder();
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					builder.append(board[y][x]).append(' ');
				}
				builder.append(System.lineSeparator());
			}

			return builder.toString();
		}
	}

	public static class Cell {
		private int x;
		private int y;
		private int value;

		public Cell(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "Cell [x=" + x + ", y=" + y + ", value=" + value + "]";
		}
	}

	private static double distance(int x, int y) {
		return Math.abs(Math.sqrt(x * x + y * y));
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}

	public static class Scanner {
		private BufferedInputStream inputStream;
		private StringBuilder buffer = new StringBuilder();

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
			int read = skip();
			do {
				buffer.append((char) read);
			} while ((read = inputStream.read()) > 0x20);

			String text = buffer.toString();
			buffer.delete(0, buffer.length());

			return text;
		}

		private int skip() throws IOException {
			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			return read;
		}
	}
}
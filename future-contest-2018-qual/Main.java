import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;

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

		long startTime = System.currentTimeMillis();

		Position[] positions = new Position[N * N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				positions[y * N + x] = new Position(x, y);
			}
		}
		Collections.shuffle(Arrays.asList(positions));

		Cell[] output = new Cell[1000];
		Board board = new Board(N, A);
		boolean[][] used = new boolean[N][N];
		for (int i = 0; i < output.length; i++) {
			Position position = positions[i];
			int diff = board.getDiff(position);
			int value = Math.min(75, Math.max(25, diff));
			board.setValue(position, value);

			output[i] = new Cell(position, value);
			used[position.y][position.x] = true;
		}

		long score = board.getScore();
		int index = output.length;
		int count = 0;
		do {
			Position newPosition = positions[index++ % positions.length];
			if (used[newPosition.y][newPosition.x]) {
				continue;
			}

			Board newBoard = board.copy();
			int newDiff = newBoard.getDiff(newPosition);
			int newValue = Math.min(80, Math.max(0, newDiff));
			newBoard.setValue(newPosition, newValue);

			long newScore = score;
			Position oldPosition = null;
			int oldValue = -1;
			int oldIndex = -1;
			for (int i = 0; i < output.length; i++) {
				Cell cell = output[i];

				long tmpScore = newBoard.tmpScore(cell.getPosition(), -cell.getValue());
				if (newScore < tmpScore) {
					newScore = tmpScore;

					oldPosition = cell.position;
					oldValue = cell.getValue();
					oldIndex = i;
				}
			}

			if (oldPosition != null) {
				used[oldPosition.y][oldPosition.x] = false;
				used[newPosition.y][newPosition.x] = true;

				board.setValue(oldPosition, -oldValue);
				board.setValue(newPosition, newValue);

				output[oldIndex] = new Cell(newPosition, newValue);
				score = newScore;
			}

			count++;
		} while (System.currentTimeMillis() - startTime <= 5750);

		output(output);
		debug(count, board.score);
	}

	public static void output(Cell[] cells) {
		StringBuilder builder = new StringBuilder();
		int count = 0;
		for (Cell cell : cells) {
			if (cell.value <= 0) {
				continue;
			}
			count++;

			builder.append(cell.getX())
					.append(' ')
					.append(cell.getY())
					.append(' ')
					.append(cell.value)
					.append(System.lineSeparator());

		}

		System.out.println(count);
		System.out.println(builder.toString());
	}

	public static class Board {
		int N;
		int[][] A;
		int[][] board;

		long score;

		public Board(int N, int[][] A) {
			this(N, A, new int[N][N]);
		}

		private Board(int N, int[][] A, int[][] board) {
			this.N = N;
			this.A = A;
			this.board = board;

			this.score = 200_000_000;
			for (int y = 0; y < board.length; y++) {
				for (int x = 0; x < board[y].length; x++) {
					score -= Math.abs(A[y][x] - board[y][x]);
				}
			}
		}

		public void setValue(Position p, int v) {
			if (v == 0) {
				return;
			}

			int value = Math.abs(v);
			int sign = v > 0 ? 1 : -1;
			int yLimit = Math.min(p.y + value, N);
			int xLimit = Math.min(p.x + value, N);

			for (int y = Math.max(0, p.y - value + 1); y < yLimit; y++) {
				int diffY = Math.abs(y - p.y);
				for (int x = Math.max(0, p.x - value + 1); x < xLimit; x++) {
					int diffX = Math.abs(x - p.x);
					int diff = diffX + diffY;
					if (diff < value) {
						score += Math.abs(A[y][x] - board[y][x]);
						board[y][x] += v - (sign * diff);
						score -= Math.abs(A[y][x] - board[y][x]);
					}
				}
			}
		}

		public long tmpScore(Position p, int v) {
			long score = this.score;
			if (v == 0) {
				return score;
			}

			int value = Math.abs(v);
			int sign = v > 0 ? 1 : -1;
			int yLimit = Math.min(p.y + value, N);
			int xLimit = Math.min(p.x + value, N);

			for (int y = Math.max(0, p.y - value + 1); y < yLimit; y++) {
				int diffY = Math.abs(y - p.y);
				for (int x = Math.max(0, p.x - value + 1); x < xLimit; x++) {
					int diffX = Math.abs(x - p.x);
					int diff = diffX + diffY;
					if (diff < value) {
						score += Math.abs(A[y][x] - board[y][x]);
						score -= Math.abs(A[y][x] - (board[y][x] + v - (sign * diff)));
					}
				}
			}

			return score;
		}

		public int getValue(Position p) {
			return board[p.y][p.x];
		}

		public int getDiff(Position p) {
			return A[p.y][p.x] - board[p.y][p.x];
		}

		public long getScore() {
			return score;
		}

		public Board copy() {
			int[][] newBoard = new int[N][];
			for (int i = 0; i < newBoard.length; i++) {
				newBoard[i] = Arrays.copyOf(board[i], board[i].length);
			}

			return new Board(N, A, newBoard);
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

	public static class Position {
		private int x;
		private int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
	}

	public static class Cell {
		private Position position;
		private int value;

		public Cell(Position position, int value) {
			this.position = position;
			this.value = value;
		}

		public Position getPosition() {
			return position;
		}

		public int getX() {
			return position.x;
		}

		public int getY() {
			return position.y;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "Cell [x=" + position.x + ", y=" + position.y + ", value=" + value + "]";
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
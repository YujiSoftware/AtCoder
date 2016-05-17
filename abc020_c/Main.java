import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

	private static int MOD = 1_000_000_007;

	private static Cell[] cells = new Cell[] {
		new Cell(0, -1),
		new Cell(1, 0),
		new Cell(0, 1),
		new Cell(-1, 0),
	};

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int T = sc.nextInt();

		Cell start = null;
		Cell goal = null;

		char[][] map = new char[H][];
		for (int y = 0; y < H; y++) {
			map[y] = sc.next().toCharArray();

			for (int x = 0; x < W; x++) {
				if (map[y][x] == 'S') {
					start = new Cell(x, y);
				}
				if (map[y][x] == 'G') {
					goal = new Cell(x, y);
				}
			}
		}

		int max = T;
		int min = 1;

		int[][] shortest = new int[H][];
		for (int y = 0; y < H; y++) {
			shortest[y] = new int[W];
		}

		while (max - min > 1) {
			int mid = min + ((max - min) / 2);

			for (int y = 0; y < H; y++) {
				for (int x = 0; x < W; x++) {
					shortest[y][x] = Integer.MAX_VALUE;
				}
			}

			Deque<Status> queue = new ArrayDeque<>();
			queue.add(new Status(new Cell(start.x, start.y)));

			boolean success = false;
			while (!queue.isEmpty()) {
				Status status = queue.removeFirst();
				Cell current = status.current;

				// 経路オーバー
				int score = status.white + (status.black * mid);
				if (T < score) {
					continue;
				}

				// 現在地点までの最短経路でなければ、以降は計算しない
				if (shortest[current.y][current.x] < score) {
					continue;
				}

				// 最短経路更新
				shortest[current.y][current.x] = score;

				if (status.getLast().equals(goal)) {
					success = true;
					break;
				}

				for (int i = 0; i < cells.length; i++) {
					Cell next = new Cell(current.x + cells[i].x, current.y + cells[i].y);

					if (!status.history.contains(next)) {
						if (0 <= next.x && next.x < W && 0 <= next.y && next.y < H) {
							queue.addFirst(new Status(status, next, isWhite(map[next.y][next.x])));
						}
					}
				}
			}

			if (success) {
				min = mid;
			} else {
				max = mid;
			}
		}

		System.out.println(min);
	}

	private static boolean isWhite(char c) {
		return c == '.' || c == 'S' || c == 'G';
	}

	private static class Status {
		private List<Cell> history;

		private Cell current;

		private int white;
		private int black;

		private Status(Status status, Cell next, boolean isWhite) {
			this.history = new ArrayList<>(status.history);
			this.add(next);

			this.white = status.white + (isWhite ? 1 : 0);
			this.black = status.black + (isWhite ? 0 : 1);
		}

		public Status(Cell cell) {
			this.history = new ArrayList<>();
			this.add(cell);

			this.white = 0;
			this.black = 0;
		}

		private void add(Cell cell) {
			this.history.add(cell);
			this.current = cell;
		}

		public Cell getLast() {
			return history.get(history.size() - 1);
		}
	}

	private static class Cell {
		private int x;
		private int y;

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
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

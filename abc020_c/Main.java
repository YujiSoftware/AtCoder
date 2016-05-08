import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

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
		int result = 0;

		while (min < max) {
			int mid = min + ((max - min) / 2);

			Queue<List<Cell>> queue = new ArrayDeque<>();
			queue.add(Collections.singletonList(new Cell(start.x, start.y)));

			boolean success = false;
			while (!queue.isEmpty()) {
				List<Cell> list = queue.poll();
				Cell last = list.get(list.size() - 1);

				int black = 0;
				int white = -1; // 開始地点は除外
				for (Cell cell : list) {
					if (isWhite(map[cell.y][cell.x])) {
						white++;
					} else {
						black++;
					}
				}

				if (black > 0 && (T - white) / black < mid) {
					continue;
				}

				if (last.x == goal.x && last.y == goal.y) {
					success = true;
					break;
				}

				for (int i = 0; i < cells.length; i++) {
					Cell next = new Cell(last.x + cells[i].x, last.y + cells[i].y);

					boolean found = false;
					for (Cell cell : list) {
						if (next.x == cell.x && next.y == cell.y) {
							found = true;
							break;
						}
					}

					if (!found) {
						if (next.x >= 0 && next.x < W && next.y >= 0 && next.y < H) {
							List<Cell> copy = new ArrayList<>(list);
							copy.add(next);

							queue.add(copy);
						}
					}
				}
			}

			if (success) {
				min = mid + 1;
				result = min;
			} else {
				max = mid - 1;
				result = max;
			}
		}

		System.out.println(result);
	}

	private static boolean isWhite(char c) {
		return c == '.' || c == 'S' || c == 'G';
	}

	private static class Cell {
		private int x;
		private int y;

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
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

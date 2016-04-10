import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {

	private final static int[][] move = new int[][] {
		new int[] { 0, -1 },
		new int[] { 1, 0 },
		new int[] { 0, 1 },
		new int[] { -1, 0 }
	};

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		Position start = new Position(sc.nextInt() - 1, sc.nextInt() - 1);
		Position goal = new Position(sc.nextInt() - 1, sc.nextInt() - 1);
		char[][] c = new char[R][];
		for (int i = 0; i < R; i++) {
			c[i] = sc.next().toCharArray();
		}

		int[][] map = new int[R][];
		for (int i = 0; i < R; i++) {
			map[i] = new int[C];
			for (int j = 0; j < C; j++) {
				map[i][j] = 9999;
			}
		}

		map[start.x][start.y] = 0;

		Queue<Position> queue = new ArrayDeque<>();
		queue.add(start);
		while (true) {
			Position p = queue.remove();
			if (p.equals(goal)) {
				break;
			}

			int next = map[p.x][p.y] + 1;
			for (int i = 0; i < move.length; i++) {
				int x = p.x + move[i][0];
				int y = p.y + move[i][1];

				if (x >= 0 && y >= 0) {
					if (c[x][y] != '#') {
						if (next < map[x][y]) {
							map[x][y] = next;
							queue.add(new Position(x, y));
						}
					}
				}
			}
			// dump(map);
		}

		System.out.println(map[goal.x][goal.y]);
	}

	private static void dump(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.err.format("%4d", map[i][j]);
				System.err.print(' ');
			}
			System.err.println();
		}
		System.err.println();
	}

	public static class Position {
		private int x;
		private int y;

		public Position(int x, int y) {
			super();
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
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}

			Position o = (Position) obj;

			return this.x == o.x && this.y == o.y;
		};

		@Override
		public String toString() {
			return "{" + x + ", " + y + "}";
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

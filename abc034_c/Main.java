import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	private static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();

		int[][] grid = new int[2][];
		for (int i = 0; i < 2; i++) {
			grid[i] = new int[W];
		}

		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				int sum = 0;
				if (x == 0 && y == 0) {
					sum = 1;
				} else {
					if (x - 1 >= 0) {
						sum += grid[y % 2][x - 1];
					}
					if (y - 1 >= 0) {
						sum += grid[(y - 1) % 2][x];
					}
				}

				grid[y % 2][x] = sum % MOD;
			}
		}

		System.out.println(grid[(H - 1) % 2][W - 1]);
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

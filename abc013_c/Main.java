import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int E = sc.nextInt();

		int min = Integer.MAX_VALUE;

		Queue<Box> queue = new ArrayDeque<>();
		queue.add(new Box(0, H, 0));
		while (!queue.isEmpty()) {
			Box box = queue.poll();
			if (box.day == N) {
				min = Math.min(min, box.money);
			} else {
				// 普通
				queue.add(new Box(box.money + A, box.satiety + B, box.day + 1));
				// 質素
				queue.add(new Box(box.money + C, box.satiety + D, box.day + 1));
				// 食事抜き
				if (box.satiety - E > 0) {
					queue.add(new Box(box.money + 0, box.satiety - E, box.day + 1));
				}
			}
		}

		System.out.println(min);
	}

	public static class Box {
		public int money;
		public int satiety;
		public int day;

		public Box(int money, int satiety, int day) {
			super();
			this.money = money;
			this.satiety = satiety;
			this.day = day;
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

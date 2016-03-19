import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Takahashi[] takahashi = new Takahashi[N];
		for (int i = 0; i < N; i++) {
			takahashi[i] = new Takahashi(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		long xSum = Arrays.stream(takahashi).mapToLong(t -> t.c * t.x).sum();
		long ySum = Arrays.stream(takahashi).mapToLong(t -> t.c * t.y).sum();
		long cSum = Arrays.stream(takahashi).mapToLong(Takahashi::getC).sum();

		double xCenter = (double) xSum / cSum;
		double yCenter = (double) ySum / cSum;

		double max = Integer.MIN_VALUE;
		for (Takahashi t : takahashi) {
			double time = t.c * Math.max(Math.abs(xCenter - t.x), Math.abs(yCenter - t.y));
			if (time > max) {
				max = time;
			}
		}

		System.out.println(max);
	}

	public static class Takahashi {
		public int x;
		public int y;
		public int c;

		public Takahashi(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
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

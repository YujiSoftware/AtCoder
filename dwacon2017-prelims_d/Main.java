import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Sushi[] sushi = new Sushi[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = new Sushi(i, sc.nextInt(), sc.nextInt());
		}
		boolean[] eat = new boolean[N];

		Arrays.sort(sushi, Comparator.comparingInt(Sushi::getX).thenComparing(Sushi::getIndex).reversed());

		int sum = 0;
		int max = -1;
		Sushi last = null;
		for (int i = 0; i < Math.min(N, M); i++) {
			sum += sushi[i].X;
			max = Math.max(max, sushi[i].getIndex());
			last = sushi[i];
			eat[sushi[i].index] = true;
		}

		Arrays.sort(sushi, Comparator.comparingInt(Sushi::getIndex));

		if (M < N) {
			int tmp = 0;
			int index = 0;
			int count = 0;
			while (index < N && count < max) {
				if (!eat[index]) {
					tmp += sushi[index].getY();
					count++;
				}
				index++;
			}

			eat[last.getIndex()] = false;
			sum += tmp;
		}

		System.out.println(sum);
	}

	public static class Sushi {
		public int index;
		public int X;
		public int Y;

		public Sushi(int index, int x, int y) {
			super();
			this.index = index;
			this.X = x;
			this.Y = y;
		}

		public int getIndex() {
			return index;
		}

		public int getX() {
			return X;
		}

		public int getY() {
			return Y;
		}
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

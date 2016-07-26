import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = sc.nextInt(N);

		int sumA = 0;
		for (int i = 0; i < N - 2; i += 2) {
			sumA += Math.abs(a[i] - a[i + 2]);
			System.err.println(sumA);
		}
		if (N % 2 == 0) {
			sumA += Math.abs(a[N - 1] - a[N - 2]);
			System.err.println(sumA);
		}
		System.err.println("---");

		int sumB = Math.abs(a[0] - a[1]);
		for (int i = 1; i < N - 2; i += 2) {
			sumB += Math.abs(a[i] - a[i + 2]);
			System.err.println(sumB);
		}
		if (N % 2 == 1) {
			sumB += Math.abs(a[N - 1] - a[N - 2]);
			System.err.println(sumB);
		}

		System.out.println(Math.min(sumA, sumB));
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

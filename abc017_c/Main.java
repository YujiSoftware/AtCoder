import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	private static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] l = new int[N];
		int[] r = new int[N];
		int[] s = new int[N];
		for (int i = 0; i < N; i++) {
			l[i] = sc.nextInt() - 1;
			r[i] = sc.nextInt() - 1;
			s[i] = sc.nextInt();
		}

		long[] score = new long[M];
		for (int i = 0; i < N; i++) {
			for (int j = l[i]; j <= r[i]; j++) {
				score[j] += s[i];
			}
		}

		long min = Long.MAX_VALUE;
		int exceptIndex = -1;
		for (int i = 0; i < M; i++) {
			if (score[i] < min) {
				min = score[i];
				exceptIndex = i;
			}
		}

		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (l[i] <= exceptIndex && exceptIndex <= r[i]) {
				continue;
			}

			sum += s[i];
		}

		System.out.println(sum);
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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] M = sc.nextInt(N);

		int sum =
			IntStream.of(M).map(m -> Math.max(80 - m, 0)).sum();

		System.out.println(sum);
	}

	public static class Scanner {
		private BufferedInputStream inputStream;

		public Scanner(InputStream in) {
			inputStream = new BufferedInputStream(in);
		}

		public int nextInt() throws IOException {
			int num = 0;

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

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

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

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

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			do {
				builder.append((char) read);
			} while ((read = inputStream.read()) > 0x20);

			return builder.toString();
		}
	}
}

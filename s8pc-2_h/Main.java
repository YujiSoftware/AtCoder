import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int Q = sc.nextInt();

		int[] q = new int[Q];
		int[] l = new int[Q];
		int[] r = new int[Q];
		for (int i = 0; i < Q; i++) {
			q[i] = sc.nextInt();
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}

		boolean[] array = new boolean[n + 1];
		for (int i = 0; i < Q; i++) {
			int left = l[i];
			int right = r[i];

			if (q[i] == 1) {
				array[left] = !array[left];
				array[right] = !array[right];
			} else if (q[i] == 2) {
				int count = 0;
				boolean now = false;
				for (int j = 0; j < right; j++) {
					if (array[j]) {
						now = !now;
					}

					if (left <= j && now) {
						count++;
					}
				}
				System.out.println(count);
			}
		}
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

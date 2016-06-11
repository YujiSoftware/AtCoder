import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();

		String[] answers = new String[] { "Do", "Re", "Mi", "Fa", "So", "La", "Si" };
		String keys = "WBWBWWBWBWBW";
		for (int i = 0; i < answers.length; i++) {
			int start = 0;
			switch (i) {
			case 0:
				start = 0;
				break;
			case 1:
				start = 2;
				break;
			case 2:
				start = 4;
				break;
			case 3:
				start = 5;
				break;
			case 4:
				start = 7;
				break;
			case 5:
				start = 9;
				break;
			case 6:
				start = 11;
				break;
			}

			String tmp = (keys.substring(start) + keys + keys).substring(0, 20);

			System.err.println(S);
			System.err.println(tmp);
			System.err.println();

			if (S.equals(tmp)) {
				System.out.println(answers[i]);
				break;
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

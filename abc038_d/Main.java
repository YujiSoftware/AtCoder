import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] box = new Pair[N];
		for (int i = 0; i < N; i++) {
			box[i] = new Pair(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(box, Comparator.comparing(Pair::getWidth));
		int[] score = new int[N];

		for (int i = 0; i < box.length; i++) {
			int maxScore = 1;
			for (int j = 0; j < i; j++) {
				if (box[i].getWidth() == box[j].getWidth()) {
					break;
				}

				if (box[j].getHeight() < box[i].getHeight()) {
					maxScore = Math.max(maxScore, score[j] + 1);
				}
			}

			score[i] = maxScore;
		}

		System.out.println(IntStream.of(score).max().getAsInt());
	}

	public static class Pair {
		private int width;
		private int height;

		public Pair(int width, int height) {
			super();
			this.width = width;
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public String toString() {
			return "{" + width + ", " + height + "}";
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

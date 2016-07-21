import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Coder[] coders = new Coder[N];
		for (int i = 0; i < coders.length; i++) {
			coders[i] = new Coder(i, sc.nextInt(), sc.nextInt() - 1);
		}

		Arrays.sort(coders, new Comparator<Coder>() {
			@Override
			public int compare(Coder o1, Coder o2) {
				return o2.rate - o1.rate;
			}
		});

		int index = 0;
		while (index < coders.length) {
			int rate = coders[index].rate;
			int[] hands = new int[3];
			int start = index;
			while (index < coders.length && rate == coders[index].rate) {
				hands[coders[index].hand]++;
				index++;
			}

			int win = coders.length - index;
			int loose = start;
			for (int i = start; i < index; i++) {
				int hand = coders[i].hand;

				coders[i].even = hands[hand] - 1;
				coders[i].win = hands[(hand + 1) % 3] + win;
				coders[i].loose = hands[(hand + 2) % 3] + loose;
			}
		}

		Arrays.sort(coders, new Comparator<Coder>() {
			@Override
			public int compare(Coder o1, Coder o2) {
				return o1.index - o2.index;
			}
		});

		StringBuilder builder = new StringBuilder(coders.length * 5);
		for (Coder coder : coders) {
			builder.append(coder.win);
			builder.append(' ');
			builder.append(coder.loose);
			builder.append(' ');
			builder.append(coder.even);
			builder.append(System.lineSeparator());
		}

		System.out.print(builder);
	}

	private static class Coder {
		public int index;
		public int rate;
		public int hand;

		public int win;
		public int loose;
		public int even;

		public Coder(int index, int rate, int hand) {
			this.index = index;
			this.rate = rate;
			this.hand = hand;
		}

		@Override
		public String toString() {
			return "Coder{" +
					"index=" + (index + 1) +
					", hand=" + hand +
					", rate=" + rate +
					'}';
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

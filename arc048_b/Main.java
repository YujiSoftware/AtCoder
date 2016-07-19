import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Human[] humans = new Human[N];
		for (int i = 0; i < humans.length; i++) {
			humans[i] = new Human(i, sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(humans);

		for (int i = 0; i < humans.length; i++) {
			int index = i;
			while (index < humans.length - 1 && humans[index].compareTo(humans[index + 1]) == 0) {
				index++;
			}

			for (int j = i; j <= index; j++) {
				humans[j].win = humans.length - index - 1;
				humans[j].loose = i;
				humans[j].even = index - i;
			}

			i = index;
		}

		Arrays.sort(humans, new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return o1.index - o2.index;
			}
		});

		StringBuilder builder = new StringBuilder(humans.length * 5);
		for (Human human : humans) {
			builder.append(human.win);
			builder.append(' ');
			builder.append(human.loose);
			builder.append(' ');
			builder.append(human.even);
			builder.append(System.lineSeparator());
		}

		System.out.print(builder);
	}

	private static class Human implements Comparable<Human> {
		public int index;
		public int rate;
		public int hand;

		public int win;
		public int loose;
		public int even;

		public Human(int index, int rate, int hand) {
			this.index = index;
			this.rate = rate;
			this.hand = hand;
		}

		public int getRate() {
			return rate;
		}

		public int getHand() {
			return hand;
		}

		@Override
		public int compareTo(Human other) {
			if (this.rate == other.rate) {
				if (this.hand == 1 && other.hand == 2
						|| this.hand == 2 && other.hand == 3
						|| this.hand == 3 && other.hand == 1) {
					return -1;
				} else if (this.hand == 1 && other.hand == 3
						|| this.hand == 2 && other.hand == 1
						|| this.hand == 3 && other.hand == 2) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return other.rate - this.rate;
			}
		}

		@Override
		public String toString() {
			return "Human{" +
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

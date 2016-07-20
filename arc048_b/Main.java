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

		Arrays.sort(humans, new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return o2.rate - o1.rate;
			}
		});

		int rate = humans[0].rate;
		int[] hands = new int[3];
		int start = 0;
		for (int i = 0; i < humans.length; i++) {
			if (rate != humans[i].rate || i == humans.length - 1) {
				int win = humans.length - i - 1;
				int loose = i;

				for (int j = start; j < i; j++) {
					switch (humans[j].hand) {
						case 1:
							humans[j].win = hands[1] + win;
							humans[j].loose = hands[2] + loose;
							humans[j].even = hands[0] - 1;
							break;
						case 2:
							humans[j].win = hands[2] + win;
							humans[j].loose = hands[0] + loose;
							humans[j].even = hands[1] - 1;
							break;
						case 3:
							humans[j].win = hands[0] + win;
							humans[j].loose = hands[1] + loose;
							humans[j].even = hands[2] - 1;
							break;
					}
				}

				rate = humans[i].rate;
				hands = new int[3];
				start = i;
			}

			hands[humans[i].hand - 1]++;
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

	private static class Human {
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

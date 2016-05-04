import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Pair[] pair = new Pair[N];
		for (int i = 0; i < pair.length; i++) {
			pair[i] = new Pair(sc.nextInt(), sc.nextInt());
		}

		double ok = 0;
		double ng = 100;
		for (int i = 0; i < 100; i++) {
			double mid = (ok + ng) / 2;

			Arrays.sort(pair, Comparator.comparing(p -> getSalt(p, mid)));

			double salt = 0;
			for (int j = 0; j < K; j++) {
				salt += getSalt(pair[N - j - 1], mid);
			}

			if (salt >= 0) {
				ok = mid;
			} else {
				ng = mid;
			}
		}

		System.out.println(ok);
	}

	private static double getSalt(Pair p, double percent) {
		return p.getWeight() * ((p.getPercent() - percent) / 100);
	}

	public static class Pair {
		private int weight;
		private int percent;

		public Pair(int weight, int percent) {
			super();
			this.weight = weight;
			this.percent = percent;
		}

		public int getWeight() {
			return weight;
		}

		public int getPercent() {
			return percent;
		}

		@Override
		public String toString() {
			return "{" + weight + ", " + percent + "}";
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

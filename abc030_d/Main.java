import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = sc.nextInt() - 1;
		BigInteger k = new BigInteger(sc.next());
		int[] b = new int[N];
		for (int i = 0; i < N; i++) {
			b[i] = sc.nextInt() - 1;
		}

		LinkedHashSet<Integer> map = new LinkedHashSet<>();

		int next = a;
		while (map.add(next)) {
			next = b[next];
		}

		int value;
		if (k.compareTo(BigInteger.valueOf(map.size())) < 0) {
			value = map.stream().skip(k.intValue()).findFirst().get();
		} else {
			int index = new ArrayList<>(map).indexOf(next);
			int m = map.size() - index;
			int mod = k.subtract(BigInteger.valueOf(next)).mod(BigInteger.valueOf(m)).intValue();

			value = map.stream().skip(next + mod).findFirst().get();
		}

		System.out.println(value + 1);
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

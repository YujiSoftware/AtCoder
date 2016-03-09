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
		int a = sc.nextInt();
		BigInteger k = new BigInteger(sc.next());
		int[] b = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			b[i] = sc.nextInt();
		}

		LinkedHashSet<Integer> map = new LinkedHashSet<>();

		int next = a;
		while (map.add(next)) {
			next = b[next];
		}

		ArrayList<Integer> list = new ArrayList<>(map);

		int value;
		if (k.compareTo(BigInteger.valueOf(map.size())) < 0) {
			value = list.get(k.intValue());
		} else {
			int start = list.indexOf(next);
			int m = map.size() - start;
			int index = k.subtract(BigInteger.valueOf(start)).mod(BigInteger.valueOf(m)).intValue();

			value = list.get(start + index);
		}

		System.out.println(value);
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

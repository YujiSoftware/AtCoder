import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		int[] A = new int[N];
		sc.fill(A);

		int odd = 0; // 奇数
		int even = 0; // 偶数
		for (int i = 0; i < N; i++) {
			if (A[i] % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}

		if (P == 0) {
			// 奇数を偶数個足す、偶数は任意の数足す
			long sumA = 0;
			for (int i = 0; i <= odd; i += 2) {
				sumA += c(odd, i);
			}
			long sumB = 0;
			for (int i = 0; i <= even; i++) {
				sumB += c(even, i);
			}
			System.out.println(sumA * sumB);
		} else {
			// 奇数を奇数個足す、偶数は任意の数足す
			long sumA = 0;
			for (int i = 1; i <= odd; i += 2) {
				sumA += c(odd, i);
			}
			long sumB = 0;
			for (int i = 0; i <= even; i++) {
				sumB += c(even, i);
			}
			System.out.println(sumA * sumB);
		}
	}

	private static long c(int n, int r) {
		return factorial(n).divide(factorial(n - r).multiply(factorial(r))).longValue();
	}

	private static BigInteger factorial(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
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

		public void fill(int[] a) throws IOException {
			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
			}
		}

		public void fill(int[] a, int[] b) throws IOException {
			if (a.length != b.length) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
				b[i] = nextInt();
			}
		}

		public long nextLong() throws IOException {
			long num = 0;

			int read = skip();
			do {
				num = num * 10 + (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public void fill(long[] a) throws IOException {
			for (int i = 0; i < a.length; i++) {
				a[i] = nextLong();
			}
		}

		public void fill(long[] a, long[] b) throws IOException {
			if (a.length != b.length) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = nextLong();
				b[i] = nextLong();
			}
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
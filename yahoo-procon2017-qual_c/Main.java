import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Set<Integer> A = new HashSet<>();
		for (int i = 0; i < K; i++) {
			A.add(sc.nextInt() - 1);
		}

		List<String> hits = new ArrayList<>();
		List<String> unhits = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String S = sc.next();
			if (A.contains(i)) {
				hits.add(S);
			} else {
				unhits.add(S);
			}
		}

		if (unhits.isEmpty()) {
			System.out.println("");
			return;
		}

		String min = hits.get(0);
		for (String hit : hits) {
			if (min.length() > hit.length()) {
				min = hit;
			}
		}

		boolean match;
		do {
			match = true;

			for (String hit : hits) {
				if (!hit.startsWith(min)) {
					min = min.substring(0, min.length() - 1);
					match = false;
					break;
				}
			}
		} while (!match && !min.isEmpty());

		String answer = null;
		while (!min.isEmpty()) {
			boolean success = true;
			for (String unhit : unhits) {
				if (unhit.startsWith(min)) {
					success = false;
					break;
				}
			}

			if (!success) {
				break;
			}

			answer = min;
			min = min.substring(0, min.length() - 1);
		}

		if (answer != null) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
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

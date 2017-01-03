import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int L = sc.nextInt();
		int[] p = new int[K];
		int[] q = new int[K];
		sc.fill(p, q);
		int[] r = new int[L];
		int[] s = new int[L];
		sc.fill(r, s);

		List<HashSet<Integer>> road = new ArrayList<>();
		List<HashSet<Integer>> train = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			HashSet<Integer> set = new HashSet<>();
			set.add(i);
			road.add(set);
		}
		for (int i = 0; i < N; i++) {
			HashSet<Integer> set = new HashSet<>();
			set.add(i);
			train.add(set);
		}

		for (int i = 0; i < K; i++) {
			road.get(p[i] - 1).add(q[i] - 1);
			road.get(q[i] - 1).add(p[i] - 1);
		}
		for (int i = 0; i < L; i++) {
			train.get(r[i] - 1).add(s[i] - 1);
			train.get(s[i] - 1).add(r[i] - 1);
		}

		boolean changed;
		do {
			changed = false;

			for (int i = 0; i < N; i++) {
				HashSet<Integer> set = road.get(i);
				for (Integer index : set.toArray(new Integer[set.size()])) {
					changed |= set.addAll(road.get(index));
				}
			}
		} while (changed);

		do {
			changed = false;

			for (int i = 0; i < N; i++) {
				HashSet<Integer> set = train.get(i);
				for (Integer index : set.toArray(new Integer[set.size()])) {
					changed |= set.addAll(train.get(index));
				}
			}
		} while (changed);

		String[] result = new String[N];
		for (int i = 0; i < N; i++) {
			HashSet<Integer> set = road.get(i);
			set.retainAll(train.get(i));

			result[i] = Integer.toString(set.size());
		}

		System.out.println(String.join(" ", result));
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

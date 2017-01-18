import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.omg.CORBA.Object;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int L = sc.nextInt();
		List<Pair> pq = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int p = sc.nextInt() - 1;
			int q = sc.nextInt() - 1;

			pq.add(new Pair(p, q));
			pq.add(new Pair(q, p));
		}
		Map<Integer, List<Integer>> road = pq.stream()
				.collect(Collectors.groupingBy(Pair::getKey, Collectors.mapping(Pair::getValue, Collectors.toList())));

		List<Pair> rs = new ArrayList<>();
		for (int i = 0; i < L; i++) {
			int r = sc.nextInt() - 1;
			int s = sc.nextInt() - 1;

			rs.add(new Pair(r, s));
			rs.add(new Pair(s, r));
		}
		Map<Integer, List<Integer>> train = rs.stream()
				.collect(Collectors.groupingBy(Pair::getKey, Collectors.mapping(Pair::getValue, Collectors.toList())));

		Map<Integer, Set<Integer>> roadMap = createMap(N, road);
		Map<Integer, Set<Integer>> trainMap = createMap(N, train);

		Map<Pair, String> cache = new HashMap<>();
		String[] result = new String[N];

		for (int i = 0; i < N; i++) {
			Set<Integer> roadSet = roadMap.getOrDefault(i, Collections.emptySet());
			Set<Integer> trainSet = trainMap.getOrDefault(i, Collections.emptySet());

			// TODO: ちゃんと等価性を比較する
			Pair hashCode = new Pair(System.identityHashCode(roadSet), System.identityHashCode(trainSet));
			String value = cache.get(hashCode);
			if (value != null) {
				result[i] = value;
			} else {
				Set<Integer> set = new HashSet<>(roadSet);
				set.retainAll(trainMap.getOrDefault(i, Collections.emptySet()));

				value = Integer.toString(set.size());

				result[i] = value;
				cache.put(hashCode, value);
			}
		}

		System.out.println(String.join(" ", result));
	}

	private static Map<Integer, Set<Integer>> createMap(int N, Map<Integer, List<Integer>> road) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (map.containsKey(i)) {
				continue;
			}

			Deque<Integer> queue = new ArrayDeque<>();
			Set<Integer> set = new HashSet<Integer>();
			queue.add(i);

			while (!queue.isEmpty()) {
				Integer index = queue.poll();
				if (set.contains(index)) {
					continue;
				}
				set.add(index);

				for (Integer value : road.getOrDefault(index, Collections.emptyList())) {
					queue.addFirst(value);
				}
			}

			for (Integer index : set) {
				map.put(index, set);
			}
		}

		return map;
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}

	public static class Pair {
		private int key;
		private int value;

		public Pair(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + key;
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(java.lang.Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (key != other.key)
				return false;
			if (value != other.value)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "{" + key + ", " + value + "}";
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
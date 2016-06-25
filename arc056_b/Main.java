import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int S = sc.nextInt();
		int[] u = new int[M];
		int[] v = new int[M];
		for (int i = 0; i < M; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		Map<Integer, List<Integer>> pair = new HashMap<>();
		for (int i = 0; i < M; i++) {
			int[] left = new int[] { v[i], u[i] };
			int[] right = new int[] { u[i], v[i] };
			for (int j = 0; j < 2; j++) {
				if (pair.containsKey(left[j])) {
					pair.get(left[j]).add(right[j]);
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(right[j]);
					pair.put(left[j], list);
				}
			}
		}

		boolean[] park = new boolean[N + 1];
		Map<Integer, List<Integer>> cacheMap = new HashMap<>();
		PARKING: for (int i = 1; i <= N; i++) {
			if (park[S]) {
				continue;
			}

			List<Integer> cache = cacheMap.get(i);
			if (cache != null && cache.stream().allMatch(s -> !park[s])) {
				System.out.println(i);
				park[i] = true;
				continue;
			}

			Deque<List<Integer>> stack = new ArrayDeque<>();
			List<Integer> first = new ArrayList<>();
			first.add(S);
			stack.push(first);

			while (!stack.isEmpty()) {
				List<Integer> list = stack.pop();
				Integer last = list.get(list.size() - 1);

				if (last == i) {
					System.out.println(i);
					park[i] = true;
					continue PARKING;
				}

				for (int next : pair.get(last)) {
					if (!park[next] && !list.contains(next)) {
						List<Integer> nextList = new ArrayList<>(list);
						nextList.add(next);

						cacheMap.put(next, nextList);

						stack.push(nextList);
					}
				}
			}
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

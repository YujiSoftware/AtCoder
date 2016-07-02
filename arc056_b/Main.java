import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

		PARKING:
		for(int i = 1; i <= N; i++){
			Deque<String> stack = new ArrayDeque<>();
			stack.push(S + ",");
			while(!stack.isEmpty()){
				String current = stack.pop();

				String[] route = current.split(",");
				int last = Integer.parseInt(route[route.length - 1]);

				if(last == i){
					System.out.println(i);
					continue PARKING;
				}else if(last < i){
					continue;
				}

				pair.get(last).stream()
						.filter(next -> !current.contains(next + ","))
						.forEach(next -> stack.push(current + next + ","));
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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();

		Map<Boolean, List<Long>> collect = S.chars().boxed()
			.collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream()
			.map(Map.Entry::getValue).collect(Collectors.partitioningBy(c -> c % 2 == 1));

		List<Long> oddList = collect.get(true);
		List<Long> evenList = collect.get(false);

		Collections.sort(oddList);
		Collections.sort(evenList, Collections.reverseOrder());

		long min = Long.MAX_VALUE;
		while (oddList.size() > 0 && evenList.size() > 0) {
			long odd = oddList.remove(0);
			long even = evenList.remove(0);
			min = Math.min(min, odd + even);
		}

		if (!oddList.isEmpty()) {
			min = Math.min(min, oddList.stream().mapToLong(odd -> odd).min().getAsLong());
		}

		if (!evenList.isEmpty()) {
			min = Math.min(min, evenList.stream().mapToLong(even -> even).sum());
		}

		System.out.println(min);
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

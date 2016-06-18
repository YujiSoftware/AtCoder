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
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()))
				.entrySet().stream()
				.map(Map.Entry::getValue)
				.collect(Collectors.partitioningBy(c -> c % 2 == 1));

		List<Long> oddList = collect.get(true);
		List<Long> evenList = collect.get(false);

		long min = Long.MAX_VALUE;
		if (oddList.size() == 0) {
			// 偶数の長さのものをすべて結合したもの
			// ex: aaaaaabbbbcc -> aaabbccbbaaa
			min = evenList.stream().mapToLong(Long::longValue).sum();
		} else if (oddList.size() > evenList.size()) {
			// 数の少ない方から奇数と偶数とつなげて、余った奇数のうち最小のもの
			// ex: succddeee ->  csc,dud,eee
			Collections.sort(oddList);
			min = oddList.get(evenList.size());
		} else {
			// 偶数をまとめて奇数と同じ個数にし、すべての組み合わせの中から最小のもの
			// ex: aabbccc -> abba,ccc -> abcccba
			while (oddList.size() < evenList.size()) {
				Collections.sort(evenList);
				evenList.add(evenList.remove(0) + evenList.remove(0));
			}

			for (long i : oddList) {
				for (long j : evenList) {
					min = Math.min(min, i + j);
				}
			}
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

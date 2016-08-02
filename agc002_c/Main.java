import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		int left = 0;
		int right = N - 1;
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		List<Integer> list = new ArrayList<>();
		while (left < right) {
			if (sum < L) {
				System.out.println("Impossible");
				return;
			}

			boolean removeLeft = false;
			boolean removeRight = false;
			int count = 1;
			if (a[left] < a[right]) {
				removeLeft = true;
			} else if (a[left] > a[right]) {
				removeRight = true;
			} else {
				for (int i = 1; left + i < right - i; i++) {
					if (a[left + i] < a[right - i]) {
						removeLeft = true;
						break;
					} else if (a[left + i] > a[right - i]) {
						removeRight = true;
						break;
					}
					count++;
				}

				if (!removeLeft && !removeRight) {
					removeLeft = removeRight = true;
				}
			}

			for (int i = 0; i < count; i++) {
				if (removeLeft) {
					list.add(left + 1);

					sum -= a[left];
					left++;
				}
				if (removeRight && left != right) {
					list.add(right);

					sum -= a[right];
					right--;
				}
			}
		}

		System.out.println("Possible");
		System.out.println(
				list.stream().map(i -> i.toString()).collect(Collectors.joining(System.lineSeparator())));
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

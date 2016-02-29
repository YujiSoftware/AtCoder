import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = reader.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		int[] s = new int[N];
		for (int i = 0; i < s.length; i++) {
			s[i] = Integer.parseInt(reader.readLine());
		}

		int length = 0;
		if (IntStream.of(s).anyMatch(i -> i == 0)) {
			length = N;
		} else {
			int left = 0;

			while (true) {
				int sum = 1;
				int right;

				for (right = left; right < N; right++) {
					sum *= s[right];
					if (sum > K) {
						break;
					}

					length = Math.max(right - left + 1, length);
				}

				if (right == N) {
					break;
				}

				left++;
			}
		}
		System.out.println(length);
	}
}

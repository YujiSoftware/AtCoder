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
		} else if (K == 0) {
			length = 0;
		} else {
			boolean[] skip = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (s[i] > K) {
					skip[i] = true;
				}
			}

			int next = 0;
			OuterLoop: for (int i = 1; i <= N; i++) {
				if (s[next] == 1) {
					length++;
					next++;
					continue;
				}

				InnerLoop: for (int j = 0; j <= N - i; j++) {
					for (int k = i - 1; k >= 0; k--) {
						if (skip[j + k]) {
							j += k;
							continue InnerLoop;
						}
					}

					long sum = s[j];
					for (int k = 1; k < i; k++) {
						if (s[j + k] != 1) {
							sum *= s[j + k];
						}
						if (sum > K) {
							break;
						}
					}

					if (sum <= K) {
						length = i;
						next = j + i;
						continue OuterLoop;
					}
				}
				break;
			}
		}

		System.out.println(length);
	}
}

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] s = new int[N];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}

		int length = 0;
		if (IntStream.of(s).anyMatch(i -> i == 0)) {
			length = N;
		} else {
			boolean[] skip = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (s[i] > K) {
					skip[i] = true;
				}
			}

			int left = 1;
			int right = N;
			OuterLoop: while (left <= right) {
				int i = (left + right) / 2;

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
						length = Math.max(i, length);

						left = i + 1;
						continue OuterLoop;
					}
				}

				right = i - 1;
			}
		}

		System.out.println(length);
	}
}

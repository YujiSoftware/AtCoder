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
		} else if (IntStream.of(s).allMatch(i -> i == 1)) {
			length = K == 0 ? 0 : N;
		} else {
			boolean[] skip = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (s[i] > K) {
					skip[i] = true;
				}
			}

			OuterLoop: for (int i = 1; i <= N; i++) {
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
						continue OuterLoop;
					}
				}
				break;
			}
		}

		System.out.println(length);
	}
}

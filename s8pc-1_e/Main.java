import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	private static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		int[] c = new int[Q + 1];
		for (int i = 0; i < Q; i++) {
			c[i] = sc.nextInt();
		}
		// 元の位置に戻る
		c[Q] = 1;

		int prev = 1;
		int[] count = new int[N];
		for (int now : c) {
			// System.err.println(prev + "->" + now);

			if (prev < now) {
				for (int j = 0; j < now - prev; j++) {
					count[prev + j]++;

					// System.err.println(prev + j);
				}
			} else {
				for (int j = 0; j < prev - now; j++) {
					count[prev - j - 1]++;

					// System.err.println(prev - j);
				}
			}

			prev = now;
		}

		long sum = 0;
		for (int i = 1; i < count.length; i++) {
			long step =
				BigInteger.valueOf(a[i - 1])
					.modPow(BigInteger.valueOf(a[i]), BigInteger.valueOf(mod))
					.longValue();

			sum = (sum + count[i] * step) % mod;
		}

		System.out.println(sum);
	}
}

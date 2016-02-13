import java.util.Scanner;

public class Main {
	/**
	 * AtCoder Beginner Contest 023 解説
	 * http://www.slideshare.net/chokudai/abc023
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] r = new int[N];
		int[] c = new int[N];
		for (int i = 0; i < N; i++) {
			r[i] = sc.nextInt() - 1;
			c[i] = sc.nextInt() - 1;
		}

		int[] rCount = new int[R];
		int[] cCount = new int[C];
		for (int i = 0; i < N; i++) {
			rCount[r[i]]++;
			cCount[c[i]]++;
		}

		int[] rSum = new int[N + 1];
		int[] cSum = new int[N + 1];
		for (int i = 0; i < rCount.length; i++) {
			rSum[rCount[i]]++;
		}
		for (int i = 0; i < cCount.length; i++) {
			cSum[cCount[i]]++;
		}

		long count = 0;
		for (int i = 0; i <= K; i++) {
			count += rSum[i] * cSum[K - i];
		}

		for (int i = 0; i < N; i++) {
			int sum = rCount[r[i]] + cCount[c[i]];
			if (sum == K) {
				count--;
			} else if (sum == K + 1) {
				count++;
			}
		}

		System.out.println(count);
	}
}

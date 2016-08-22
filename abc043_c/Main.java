import java.util.Scanner;

public class Main {

	private static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		int result = Integer.MAX_VALUE / 2;
		for (int i = -100; i <= 100; i++) {
			int sum = 0;
			for (int j = 0; j < a.length; j++) {
				sum += Math.pow(i - a[j], 2);
			}

			result = Math.min(result, sum);
		}

		System.out.println(result);
	}
}

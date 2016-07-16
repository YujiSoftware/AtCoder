import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] L = new int[2 * N];
		for (int i = 0; i < 2 * N; i++) {
			L[i] = sc.nextInt();
		}

		Arrays.sort(L);

		long sum = 0;
		for (int i = 0; i < 2 * N; i += 2) {
			sum += Math.min(L[i], L[i + 1]);
		}

		System.out.println(sum);
	}
}

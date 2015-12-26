import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		int sum = 0;
		int close = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] < close) {
				sum += T - (close - A[i]);
			} else {
				sum += T;
			}

			close = A[i] + T;
		}

		System.out.println(sum);
	}
}

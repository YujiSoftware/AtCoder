import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int T = sc.nextInt();
		int W = sc.nextInt();
		int[] A = new int[N];
		for (int i = 1; i < N; i++) {
			A[i] = sc.nextInt();
		}

		int now = W;
		int count = (S <= now && now <= T) ? 1 : 0;
		for (int i = 1; i < N; i++) {
			now += A[i];

			if (S <= now && now <= T) {
				count++;
			}
		}

		System.out.println(count);
	}
}

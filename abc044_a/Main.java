import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();

		if (K < N) {
			System.out.println(K * X + (N - K) * Y);
		} else {
			System.out.println(N * X);
		}
	}
}

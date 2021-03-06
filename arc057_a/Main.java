import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		int K = sc.nextInt();

		long days = 0;
		if (K == 0) {
			days = 2_0000_0000_0000L - A;
		} else {
			while (A < 2_0000_0000_0000L) {
				A += 1 + K * A;
				days++;
			}
		}

		System.out.println(days);
	}
}

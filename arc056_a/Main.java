import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int K = sc.nextInt();
		int L = sc.nextInt();

		double bara = (double) B / L;
		if (bara < A) {
			long set = K / L;
			long mikan = set * L;
			System.err.println(mikan);

			if (B < A * (K - mikan)) {
				System.out.println(B * (set + 1));
			} else {
				System.out.println((B * set) + A * (K - mikan));
			}
		} else {
			System.out.println(A * K);
		}
	}
}

import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int S = sc.nextInt();
		int D = sc.nextInt();

		if (S < D) {
			double forward = (D - S) / (double) (X + Y);
			double backward = (L - D + S) / (double) Math.abs(Y - X);

			System.out.println(Math.min(forward, backward));
		} else {
			double forward = (L - S + D) / (double) (X + Y);
			double backward = (S - D) / (double) Math.abs(Y - X);

			System.out.println(Math.min(forward, backward));
		}
	}
}

import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int S = sc.nextInt();
		int D = sc.nextInt();

		double forward;
		double backward;
		if (S < D) {
			forward = (D - S) / (double) (X + Y);
			backward = (L - D + S) / (double) (Y - X);
		} else {
			forward = (L - S + D) / (double) (X + Y);
			backward = (S - D) / (double) (Y - X);
		}

		if (backward < 0.0) {
			System.out.println(forward);
		} else {
			System.out.println(Math.min(forward, backward));
		}
	}
}

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
			forward = (double) (D - S) / (X + Y);
			backward = (double) (L - D + S) / (Y - X);
		} else {
			forward = (double) (L - S + D) / (X + Y);
			backward = (double) (S - D) / (Y - X);
		}

		if (backward < 0.0) {
			System.out.println(forward);
		} else if (Double.isNaN(backward)) {
			System.out.println(0);
		} else {
			System.out.println(Math.min(forward, backward));
		}
	}
}

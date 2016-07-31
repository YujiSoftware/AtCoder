import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		String Positive = "Positive";
		String Negative = "Negative";
		String Zero = "Zero";

		if (a <= 0 && b >= 0) {
			System.out.println(Zero);
		} else if (a > 0) {
			System.out.println(Positive);
		} else {
			if (a == b) {
				System.out.println(Negative);
			} else if (Math.abs(b - a) % 2 == 0) {
				System.out.println(Negative);
			} else {
				System.out.println(Positive);
			}
		}
	}
}

import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (A < B) {
			System.out.println(C / A);
		} else {
			System.out.println(C / B);
		}
	}
}

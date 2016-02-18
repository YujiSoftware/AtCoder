import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		boolean plus = A + B == C;
		boolean minus = A - B == C;

		if (plus && minus) {
			System.out.println("?");
		} else if (plus && !minus) {
			System.out.println("+");
		} else if (!plus && minus) {
			System.out.println("-");
		} else {
			System.out.println("!");
		}
	}
}

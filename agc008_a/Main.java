import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		if (x <= y) {
			if (x >= 0 && y >= 0) {
				System.out.println(Math.abs(y - x));
				System.err.println(1);
			} else if (x <= 0 && y <= 0) {
				System.out.println(Math.abs(y - x));
				System.err.println(2);
			} else {
				System.out.println(Math.abs(y + x) + 1);
				System.err.println(3);
			}
		} else {
			if (x > 0 && y > 0) {
				System.out.println(Math.abs(x - y) + 2);
				System.err.println(4);
			} else if (x < 0 && y < 0) {
				System.out.println(Math.abs(x - y) + 2);
				System.err.println(5);
			} else {
				System.out.println(Math.abs(x + y) + 1);
				System.err.println(6);
			}
		}
	}
}

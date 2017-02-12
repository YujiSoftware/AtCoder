import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		if (A == 1) {
			A = 14;
		}
		if (B == 1) {
			B = 14;
		}

		if (A > B) {
			System.out.println("Alice");
		} else if (A < B) {
			System.out.println("Bob");
		} else {
			System.out.println("Draw");
		}
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}
}

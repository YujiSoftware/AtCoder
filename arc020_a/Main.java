import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A = Math.abs(sc.nextInt());
		int B = Math.abs(sc.nextInt());

		if (A < B) {
			System.out.println("Ant");
		} else if (A > B) {
			System.out.println("Bug");
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

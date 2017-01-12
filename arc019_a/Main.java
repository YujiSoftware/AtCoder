import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine()
				.replace('O', '0')
				.replace('D', '0')
				.replace('I', '1')
				.replace('Z', '2')
				.replace('S', '5')
				.replace('B', '8');

		System.out.println(S);
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}
}

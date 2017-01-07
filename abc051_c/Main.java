import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int tx = sc.nextInt();
		int ty = sc.nextInt();

		StringBuilder sb = new StringBuilder(((ty - sy) + (tx - sx)) * 4 + 8);
		for (int y = sy; y < ty; y++) {
			sb.append('U');
		}
		for (int x = sx; x < tx; x++) {
			sb.append('R');
		}
		for (int y = sy; y < ty; y++) {
			sb.append('D');
		}
		for (int x = sx; x < tx; x++) {
			sb.append('L');
		}

		sb.append('L');
		for (int y = sy; y < ty + 1; y++) {
			sb.append('U');
		}
		for (int x = sx; x < tx + 1; x++) {
			sb.append('R');
		}
		sb.append('D');

		sb.append('R');
		for (int y = sy; y < ty + 1; y++) {
			sb.append('D');
		}
		for (int x = sx; x < tx + 1; x++) {
			sb.append('L');
		}
		sb.append('U');

		System.out.println(sb);
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}
}

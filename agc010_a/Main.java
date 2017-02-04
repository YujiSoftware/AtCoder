import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		int 偶数 = 0;
		int 奇数 = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] % 2 == 0) {
				偶数++;
			} else {
				奇数++;
			}
		}

		System.out.println(奇数 % 2 == 0 ? "YES" : "NO");
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}
}

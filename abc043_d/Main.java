import java.util.Scanner;

public class Main {

	private static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();

		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				int[] counter = new int['z' - 'a' + 1];
				for (int k = i; k <= j; k++) {
					counter[s[k] - 'a']++;
				}

				int max = Integer.MIN_VALUE;
				for (int c : counter) {
					if (max < c) {
						max = c;
					}
				}

				int half = (j - i + 1) / 2;
				if (half < max) {
					System.out.println((i + 1) + " " + (j + 1));
					return;
				}
			}
		}
		System.out.println("-1 -1");
	}
}

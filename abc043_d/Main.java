import java.util.Scanner;

public class Main {

	private static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();

		for (int i = 0; i < s.length; i++) {
			if (i + 1 < s.length && s[i] == s[i + 1]) {
				System.out.println((i + 1) + " " + (i + 2));
				return;
			} else if (i + 2 < s.length && s[i] == s[i + 2]) {
				System.out.println((i + 1) + " " + (i + 3));
				return;
			}
		}
		System.out.println("-1 -1");
	}
}

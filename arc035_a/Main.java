import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();

		int len = S.length;
		for (int i = 0; i < len / 2; i++) {
			int left = i;
			int right = len - i - 1;
			if (S[left] != S[right] && S[left] != '*' && S[right] != '*') {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
		return;
	}
}

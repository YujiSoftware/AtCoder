import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();

		long result = 0;
		char prev = 'O';
		for (char c : S) {
			if (c != prev) {
				result++;
				prev = c;
			}
		}

		if (prev == 'O') {
			if (result > 0) {
				result--;
			}
		}

		System.out.println(result == 0 || result == 2 ? 0 : result);
	}
}

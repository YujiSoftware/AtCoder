import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.nextLine().toCharArray();
		char[] X = "CODEFESTIVAL2016".toCharArray();

		int count = 0;
		for (int i = 0; i < S.length; i++) {
			if (S[i] != X[i]) {
				count++;
			}
		}

		System.out.println(count);
	}
}

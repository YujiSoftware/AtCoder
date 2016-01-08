import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();
		int N = sc.nextInt();
		int[] l = new int[N];
		int[] r = new int[N];
		for (int i = 0; i < N; i++) {
			l[i] = sc.nextInt() - 1;
			r[i] = sc.nextInt() - 1;
		}

		for (int i = 0; i < N; i++) {
			char[] tmp = new char[S.length];
			for (int j = 0; j < l[i]; j++) {
				tmp[j] = S[j];
			}
			for (int j = l[i]; j <= r[i]; j++) {
				tmp[j] = S[l[i] + r[i] - j];
			}
			for (int j = r[i] + 1; j < S.length; j++) {
				tmp[j] = S[j];
			}

			S = tmp;
		}

		System.out.println(new String(S));
	}
}

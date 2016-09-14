import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] D = new int[7];
		int[] J = new int[7];
		for (int i = 0; i < 7; i++) {
			D[i] = sc.nextInt();
		}
		for (int i = 0; i < 7; i++) {
			J[i] = sc.nextInt();
		}

		long sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += Math.max(D[i], J[i]);
			System.err.println(sum);
		}

		System.out.println(sum);
	}
}

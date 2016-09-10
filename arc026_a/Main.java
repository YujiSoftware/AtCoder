import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();

		int sum = Math.min(N, 5) * B + Math.max(N - 5, 0) * A;

		System.out.println(sum);
	}
}

import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		long sum = 0;
		sum += A * B * 2;
		sum += A * C * 2;
		sum += B * C * 2;

		System.out.println(sum);
	}
}

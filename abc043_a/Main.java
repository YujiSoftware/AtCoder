import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += i + 1;
		}

		System.out.println(sum);
	}
}

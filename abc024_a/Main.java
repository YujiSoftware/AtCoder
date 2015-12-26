import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int K = sc.nextInt();

		int S = sc.nextInt();
		int T = sc.nextInt();

		int sum = A * S + B * T;
		if (S + T >= K) {
			sum -= (S + T) * C;
		}

		System.out.println(sum);
	}
}

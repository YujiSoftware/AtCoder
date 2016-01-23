import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;
		for (int i = 25; i <= N; i += 25) {
			count++;
		}

		System.out.println(count);
	}
}

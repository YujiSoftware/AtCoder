import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] s = new int[3];
		int[] e = new int[3];
		for (int i = 0; i < 3; i++) {
			s[i] = sc.nextInt();
			e[i] = sc.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += (s[i] * e[i]) / 10;
		}

		System.out.println(sum);
	}
}

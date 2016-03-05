import java.util.Scanner;

class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		if ((A < 0 && B < 0) || (A > 0 && B > 0)) {
			System.out.println(B - A);
		} else {
			System.out.println(B - (A + 1));
		}
	}
}

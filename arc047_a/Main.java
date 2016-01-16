import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		char[] S = sc.next().toCharArray();

		int count = 0;
		int now = 1;
		for (char s : S) {
			if (s == '+') {
				now++;
			} else {
				now--;
			}

			if (L < now) {
				count++;
				now = 1;
			}
		}

		System.out.println(count);
	}
}

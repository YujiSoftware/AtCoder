import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();

		boolean result = true;
		for (int i = 1; i < 4; i++) {
			if (!N.substring(i, i + 1).equals(N.substring(0, 1))) {
				result = false;
				break;
			}
		}

		System.out.println(result ? "SAME" : "DIFFERENT");
	}
}

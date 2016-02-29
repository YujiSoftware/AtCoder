import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		int R = 0;
		int B = 0;

		for (int i = 0; i < N; i++) {
			String S = sc.nextLine();
			for (char s : S.toCharArray()) {
				switch (s) {
				case 'R':
					R++;
					break;
				case 'B':
					B++;
					break;
				}
			}
		}

		if (R > B) {
			System.out.println("TAKAHASHI");
		} else if (R < B) {
			System.out.println("AOKI");
		} else {
			System.out.println("DRAW");
		}
	}
}

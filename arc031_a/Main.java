import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] Name = sc.nextLine().toCharArray();

		for (int i = 0; i < Name.length / 2; i++) {
			if (Name[i] != Name[Name.length - i - 1]) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}
}

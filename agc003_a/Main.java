import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();

		boolean n = S.chars().anyMatch(c -> c == 'N');
		boolean w = S.chars().anyMatch(c -> c == 'W');
		boolean s = S.chars().anyMatch(c -> c == 'S');
		boolean e = S.chars().anyMatch(c -> c == 'E');

		if (n ^ s || w ^ e) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
}

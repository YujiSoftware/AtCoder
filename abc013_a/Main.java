import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String X = sc.nextLine();
		char c = X.charAt(0);

		System.out.println(c - 'A' + 1);
	}
}

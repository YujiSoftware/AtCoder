import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int i = sc.nextInt();

		System.out.println(s.substring(i - 1, i));
	}
}

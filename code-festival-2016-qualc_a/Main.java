import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int C = s.lastIndexOf('C');
		int F = s.lastIndexOf('F');
		if (C == -1 || F == -1 || C > F) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
}

import java.io.IOException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		boolean result = a == b + c || b == a + c || c == a + b;

		System.out.println(result ? "Yes" : "No");
	}
}

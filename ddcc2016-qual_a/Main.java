import java.io.IOException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		System.out.println((double) C / A * B);
	}
}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long x = sc.nextLong();

		long sum;
		if (a > 0) {
			sum = (b / x) - ((a - 1) / x);
		} else {
			sum = b / x + 1;
		}

		System.out.println(sum);
	}
}

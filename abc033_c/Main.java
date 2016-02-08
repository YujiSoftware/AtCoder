import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] S = sc.nextLine().split("\\+");

		int count = 0;
		for (String str : S) {
			if (!str.contains("0")) {
				count++;
			}
		}

		System.out.println(count);
	}
}

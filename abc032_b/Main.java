import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();

		Set<String> password = new HashSet<String>();
		for (int i = 0; i < s.length() - k + 1; i++) {
			password.add(s.substring(i, i + k));
		}

		System.out.println(password.size());
	}
}

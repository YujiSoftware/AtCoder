import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	private static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String w = sc.next();

		boolean beautiful = w.chars().boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.values().stream()
				.allMatch(v -> v % 2 == 0);

		System.out.println(beautiful ? "Yes" : "No");
	}
}

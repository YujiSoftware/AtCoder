import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.SECOND, N);

		System.out.printf("%tT%n", calendar.getTime());
	}
}

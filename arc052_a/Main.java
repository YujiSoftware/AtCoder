import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		Matcher matcher = Pattern.compile("\\d+").matcher(S);
		matcher.find();

		System.out.println(matcher.group());
	}
}

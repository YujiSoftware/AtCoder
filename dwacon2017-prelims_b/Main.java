import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] T = sc.nextLine().toCharArray();

		int max = 0;
		int length = 0;
		char begin = ' ';
		char end = ' ';

		for (int i = 0; i < T.length; i++) {
			char current = i % 2 == 0 ? '2' : '5';
			boolean match;
			if (T[i] == current || T[i] == '?') {
				if (length == 0) {
					begin = current;
				}
				end = current;
				length++;
				match = true;
			} else {
				match = false;
			}

			if (!match || i == T.length - 1) {
				if (begin == '5')
					length--;
				if (end == '2')
					length--;
				max = Math.max(max, length);
				length = 0;
			}
		}

		for (int i = 0; i < T.length; i++) {
			char current = i % 2 == 0 ? '5' : '2';
			boolean match;
			if (T[i] == current || T[i] == '?') {
				if (length == 0) {
					begin = current;
				}
				end = current;
				length++;
				match = true;
			} else {
				match = false;
			}

			if (!match || i == T.length - 1) {
				if (begin == '5')
					length--;
				if (end == '2')
					length--;
				max = Math.max(max, length);
				length = 0;
			}
		}

		System.out.println(max);
	}
}

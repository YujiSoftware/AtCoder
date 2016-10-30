import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		String t = sc.next();

		int length = s.length() + t.length();
		for (int i = 0; i < s.length(); i++) {
			boolean match = true;
			for (int j = 0; j < Math.min(s.length() - i, t.length()); j++) {
				if (s.charAt(i + j) != t.charAt(j)) {
					match = false;
					break;
				}
			}

			if (match) {
				length = i + t.length();
			}
		}

		System.out.println(length);
	}
}

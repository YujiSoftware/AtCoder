import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int r = sc.nextInt();

		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();

		int top = y1 + r;
		int right = x1 + r;
		int bottom = y1 - r;
		int left = x1 - r;

		if (x2 <= left && right <= x3 && y2 <= bottom && top <= y3) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

		if (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) < r &&
			Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y2 - y1, 2)) < r &&
			Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y3 - y1, 2)) < r &&
			Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2)) < r) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
}

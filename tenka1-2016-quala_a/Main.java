import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			boolean flag = false;
			if (i % 3 == 0) {
				// System.out.println("天下一");
				flag = true;
			}
			if (i % 5 == 0) {
				// System.out.println("プログラマー");
				flag = true;
			}

			if (!flag) {
				// System.out.println(i);
				sum += i;
			}
		}

		System.out.println(sum);
	}
}

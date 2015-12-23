import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		Direction[] s = new Direction[N];
		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			s[i] = Direction.valueOf(sc.next());
			d[i] = sc.nextInt();
		}

		int position = 0;
		for (int i = 0; i < N; i++) {
			int x = s[i] == Direction.West ? 1 : -1;

			if (d[i] < A) {
				position += x * A;
			} else if (d[i] > B) {
				position += x * B;
			} else {
				position += x * d[i];
			}
		}

		if (position == 0) {
			System.out.println(0);
		} else {
			if (position > 0) {
				System.out.println("West " + Math.abs(position));
			} else {
				System.out.println("East " + Math.abs(position));
			}
		}

	}

	private static enum Direction {
		West, East
	}
}
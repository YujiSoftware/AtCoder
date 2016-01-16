import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		Query[] query = new Query[Q];
		for (int i = 0; i < Q; i++) {
			int num = sc.nextInt();
			if (num == 1) {
				query[i] = new Query1(sc);
			} else if (num == 2) {
				query[i] = new Query2(sc);
			} else if (num == 3) {
				query[i] = new Query3(sc);
			}
		}

		int[][] mass = new int[N][];
		for (int i = 0; i < N; i++) {
			mass[i] = new int[N];
		}

		int row = 1;
		for (Query q : query) {
			q.operate(mass);
			// dump(row++);
		}
	}

	private static void dump(int row, int[][] mass) {
		System.err.println(row);
		for (int y = 0; y < mass.length; y++) {
			for (int x = 0; x < mass.length; x++) {
				System.err.printf("%4d", mass[x][y]);
				System.err.print(" ");
			}
			System.err.println();
		}
		System.err.println();
	}

	private static abstract class Query {
		public abstract void operate(int[][] mass);
	}

	private static class Query1 extends Query {
		private int A;
		private int B;
		private int C;

		public Query1(Scanner sc) {
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
		}

		public void operate(int[][] mass) {
			for (int y = 0; y < mass.length; y++) {
				int left = Math.max(0, A - y);
				int right = Math.min(mass.length, B - y + 1);
				for (int x = left; x < right; x++) {
					mass[x][y] += C;
				}
			}
		}
	}

	private static class Query2 extends Query {
		private int A;
		private int B;
		private int C;

		public Query2(Scanner sc) {
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
		}

		public void operate(int[][] mass) {
			for (int y = 0; y < mass.length; y++) {
				int left = Math.max(0, A + y);
				int right = Math.min(mass.length, B + y + 1);
				for (int x = left; x < right; x++) {
					mass[x][y] += C;
				}
			}
		}
	}

	private static class Query3 extends Query {
		private int A;
		private int B;
		private int C;
		private int D;

		public Query3(Scanner sc) {
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			D = sc.nextInt();
		}

		public void operate(int[][] mass) {
			int max = Integer.MIN_VALUE;
			int count = 0;

			int left = Math.max(0, A);
			int right = Math.min(mass.length, B + 1);
			for (int x = left; x < right; x++) {
				int top = Math.max(0, C);
				int bottom = Math.min(mass.length, D + 1);
				for (int y = top; y < bottom; y++) {
					if (mass[x][y] == max) {
						count++;
					} else if (mass[x][y] > max) {
						max = mass[x][y];
						count = 1;
					}
				}
			}

			System.out.println(max + " " + count);
		}
	}
}

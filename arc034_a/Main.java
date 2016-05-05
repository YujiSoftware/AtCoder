import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N];
		int[] d = new int[N];
		int[] e = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
			e[i] = sc.nextInt();
		}

		double factor = (double) 110 / 900;
		double max = Double.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			double score = a[i] + b[i] + c[i] + d[i] + (e[i] * factor);

			if (max < score) {
				max = score;
			}
		}

		System.out.println(max);
	}
}

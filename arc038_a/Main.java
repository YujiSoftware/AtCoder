import java.util.Arrays;
import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A);
		ArrayUtils.reverse(A);

		int sum = 0;
		for (int i = 0; i < A.length; i += 2) {
			sum += A[i];
		}

		System.out.println(sum);
	}

	private static class ArrayUtils {

		public static void reverse(int[] a) {
			for (int i = 0; i < a.length / 2; i++) {
				int tmp = a[i];
				a[i] = a[a.length - i - 1];
				a[a.length - i - 1] = tmp;
			}
		}
	}
}

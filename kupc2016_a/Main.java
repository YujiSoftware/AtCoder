import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] t = new int[N];
		for (int i = 0; i < N; i++) {
			t[i] = sc.nextInt();
		}

		long count = IntStream.of(t).filter(i -> i < A || B <= i).count();

		System.out.println(count);
	}
}

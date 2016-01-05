import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);

		Set<Integer> used = new HashSet<>(N);
		int count = 0;
		for (int val : A) {
			if (!used.contains(val)) {
				count++;

				int temp = val * 2;
				while (temp <= 1000000000) {
					used.add(temp);
					temp *= 2;
				}
			}
		}

		System.out.println(count);
	}
}

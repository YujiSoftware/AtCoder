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

		int count = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			if (!set.add(A[i])) {
				count++;
			}
		}

		System.out.println(count);
	}
}

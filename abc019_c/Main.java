import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Set<Integer> A = new TreeSet<>();
		Set<Integer> used = new HashSet<>(N);
		for (int i = 0; i < N; i++) {
			A.add(sc.nextInt());
		}

		int count = 0;
		for (Integer val : A) {
			if (!used.contains(val)) {
				count++;
			}

			used.add(val * 2);
		}

		System.out.println(count);
	}
}

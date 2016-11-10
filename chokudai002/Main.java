import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
	public static void main(String[] args) throws IOException {
		int step = 2;
		int[] primes = new int[500000];
		try (Scanner sc = new Scanner(
				Files.newInputStream(Paths.get("R:\\素数.txt")))) {
			for (int i = 0; i < primes.length; i++) {
				primes[i] = sc.nextInt();
			}
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; set.size() < 100; i += step) {
			int prime = primes[i + step - 1];
			OUTER_LOOP: for (int j = prime; j < 1e9; j += prime) {
				for (int k = 0; k < step - 1; k++) {
					if (j % primes[i + k] != 0) {
						continue OUTER_LOOP;
					}
				}

				int value = (int) (1e9 / j) * j;
				value = j;

				if (!set.contains(value)) {
					System.out.println(value);
					set.add(value);
				}
				break;
			}
			// System.err.println(set.size());
		}
	}

	private static long gcd(long m, long n) {
		long temp;
		while (m % n != 0) {
			temp = n;
			n = m % n;
			m = temp;
		}
		return n;
	}
}

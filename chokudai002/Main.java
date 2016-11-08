import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
	public static void main(String[] args) throws IOException {
		int step = 3;
		int[] primes = new int[100000];
		try (Scanner sc = new Scanner(
				Files.newInputStream(Paths.get("R:\\素数.txt")))) {
			for (int i = 0; i < primes.length; i++) {
				primes[i] = sc.nextInt();
			}
		}

		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		for (int i = 0; set.size() < 100; i += step) {
			long sum = 1;
			for (int j = i; j < i + step; j++) {
				sum *= primes[j];
			}

			long min = 1;
			for (int j = 0; j < step; j++) {
				long gcd = gcd(sum, primes[i + j]);
				// System.out.println(gcd);

				min *= gcd;
			}

			// int value = (int) (sum / min);
			int value = (int) sum;
			value = (int) (1e9 / value) * value;

			if (!set.contains(value)) {
				System.out.println(value);
				set.add(value);
			}
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

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] S = new String[N];
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			S[i] = sc.next();
			P[i] = sc.nextInt();
		}

		int sum = IntStream.of(P).sum();
		String result = "atcoder";
		for (int i = 0; i < N; i++) {
			if (P[i] > (sum / 2.0)) {
				result = S[i];
				break;
			}
		}

		System.out.println(result);
	}

	public static class Pair {
		private int key;
		private int value;

		public Pair(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "{" + key + ", " + value + "}";
		}
	}
}

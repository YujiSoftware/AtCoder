import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.nextLine().toCharArray();

		boolean choku = true;
		for (int i = 0; i < S.length; i++) {
			if (S[i] == 'c') {
				if (i + 1 < S.length && S[i + 1] == 'h') {
					i++;
					continue;
				}
			} else if (S[i] == 'o' || S[i] == 'k' || S[i] == 'u') {
				continue;
			}

			choku = false;
			break;
		}

		System.out.println(choku ? "YES" : "NO");
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

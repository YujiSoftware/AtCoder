import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[M];
		for (int i = 0; i < M; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// スレッドの初期化
		Pair[] threads = new Pair[N];
		for (int i = 0; i < N; i++) {
			threads[i] = new Pair(i + 1, N);
		}

		// スレッドの「最終書き込み番号」を更新
		int index = N + 1;
		for (int threadId : a) {
			threads[threadId - 1].value = index++;
		}

		// 最終書き込み番号順にソート
		Arrays.parallelSort(threads, Comparator.comparingInt(Pair::getValue).reversed());

		// 出力
		for (Pair thread : threads) {
			System.out.println(thread.key);
		}
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

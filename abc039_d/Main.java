import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int H = sc.nextInt();
		BitSet[] S = new BitSet[H];
		for (int i = 0; i < H; i++) {
			S[i] = new BitSet(W);

			char[] line = sc.next().toCharArray();
			for (int j = 0; j < W; j++) {
				if (line[j] == '#') {
					S[i].set(j);
				}
			}
		}

		// 復元
		BitSet[] map = new BitSet[H];
		for (int i = 0; i < H; i++) {
			map[i] = new BitSet(W);
			map[i].or(S[i]);
		}

		for (int i = 0; i < H; i++) {
			if (i - 1 >= 0) {
				map[i].and(leftShift(S[i - 1], W));
				map[i].and(S[i - 1]);
				map[i].and(rightShift(S[i - 1]));
			}
			if (i + 1 < H) {
				map[i].and(leftShift(S[i + 1], W));
				map[i].and(S[i + 1]);
				map[i].and(rightShift(S[i + 1]));
			}

			map[i].and(leftShift(S[i], W));
			map[i].and(rightShift(S[i]));
		}

		// 復元結果の作成
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				builder.append(map[i].get(j) ? '#' : '.');
			}
			builder.append(System.lineSeparator());
		}

		// 収縮
		BitSet[] base = new BitSet[H];
		for (int i = 0; i < H; i++) {
			base[i] = new BitSet(W);
		}

		for (int i = 0; i < H; i++) {
			if (i - 1 >= 0) {
				base[i].or(leftShift(map[i - 1], W));
				base[i].or(map[i - 1]);
				base[i].or(rightShift(map[i - 1]));
			}
			if (i + 1 < H) {
				base[i].or(leftShift(map[i + 1], W));
				base[i].or(map[i + 1]);
				base[i].or(rightShift(map[i + 1]));
			}

			base[i].or(leftShift(map[i], W));
			base[i].or(rightShift(map[i]));
		}

		// 答え合わせ
		boolean success = true;
		for (int i = 0; i < H; i++) {
			S[i].andNot(base[i]);
			if (!S[i].isEmpty()) {
				success = false;
				break;
			}
		}

		if (success) {
			System.out.println("possible");
			System.out.print(builder);
		} else {
			System.out.println("impossible");
		}
	}

	private static BitSet leftShift(BitSet bits, int W) {
		BitSet newBits = bits.get(1, bits.size() - 1);
		if (bits.get(W - 1)) {
			newBits.set(W - 1);
		}

		return newBits;
	}

	private static BitSet rightShift(BitSet bits) {
		BitSet newBits = new BitSet(bits.size());
		for (int i = bits.nextSetBit(0); i >= 0; i = bits.nextSetBit(i + 1)) {
			newBits.set(i + 1);
		}
		if (bits.get(0)) {
			newBits.set(0);
		}

		return newBits;
	}

	private static void debug(BitSet[] map, int W) {
		for (int i = 0; i < map.length; i++) {
			debug(map[i], W);
		}
		System.err.println();
	}

	private static void debug(BitSet map, int W) {
		for (int j = 0; j < W; j++) {
			System.err.print(map.get(j) ? '#' : '.');
		}
		System.err.println();
	}

	public static class Pair {
		private int width;
		private int height;

		public Pair(int width, int height) {
			super();
			this.width = width;
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public String toString() {
			return "{" + width + ", " + height + "}";
		}
	}

	public static class Scanner {
		private BufferedInputStream inputStream;

		public Scanner(InputStream in) {
			inputStream = new BufferedInputStream(in);
		}

		public int nextInt() throws IOException {
			int num = 0;

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			do {
				num = num * 10 + (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public int[] nextInt(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}

			return array;
		}

		public long nextLong() throws IOException {
			long num = 0;

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			do {
				num = num * 10 + (read - 0x30);
			} while ((read = inputStream.read()) > 0x20);

			return num;
		}

		public long[] nextLong(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextLong();
			}

			return array;
		}

		public String next() throws IOException {
			StringBuilder builder = new StringBuilder();

			int read;
			while ((read = inputStream.read()) <= 0x20)
				;

			do {
				builder.append((char) read);
			} while ((read = inputStream.read()) > 0x20);

			return builder.toString();
		}
	}
}

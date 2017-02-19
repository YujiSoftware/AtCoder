import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long start = System.currentTimeMillis();

		List<char[]> input = new ArrayList<>();
		while (sc.hasNextLine()) {
			input.add(sc.nextLine().toCharArray());
		}
		char[][] S = input.toArray(new char[input.size()][]);

		List<int[]> dots = new ArrayList<>();
		for (int y = S.length - 1; y >= 0; y--) {
			for (int x = 0; x < S[y].length; x++) {
				if (S[y][x] == '.') {
					dots.add(new int[] { y, x });
				}
			}
		}

		int step = 3;
		char[][] matrix = new char[(int) Math.pow(3, step)][step];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < step; j++) {
				int index = i / (int) Math.pow(3, j);
				char c = index % 3 == 0 ? '.' : (index % 3 == 1 ? '+' : '-');

				matrix[i][j] = c;
			}
		}

		int max = score(S);
		int loop = 0;
		while (System.currentTimeMillis() - start < 9000) {
			loop++;

			for (int i = loop; i < dots.size(); i += step) {
				for (int j = 0; j < matrix.length; j++) {
					char[][] copy = deepCopy(S);

					for (int k = 0; k < step; k++) {
						int[] d = dots.get((i + k) % dots.size());
						int y = d[0];
						int x = d[1];

						copy[y][x] = matrix[j][k];
					}

					char[][] down = falldown(copy);
					// debug(output(copy), output(down), score(down));
					int score = score(down);
					if (max < score) {
						max = score;
						S = copy;
					}
				}
			}
		}

		char[][] down = falldown(S);
		debug(output(down), score(down), loop);

		System.out.println(output(S));
	}

	private static char[][] deepCopy(char[][] original) {
		final char[][] result = new char[original.length][];
		for (int i = 0; i < original.length; i++) {
			result[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return result;
	}

	public static String output(char[][] S) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < S.length; i++) {
			result.append(S[i]);
			result.append(System.lineSeparator());
		}
		return result.toString();
	}

	public static char[][] falldown(char[][] original) {
		char[][] s = deepCopy(original);
		for (int x = 0; x < s[0].length; x++) {
			int skip = 0;
			for (int y = s.length - 1; y >= 0; y--) {
				while (y - skip >= 0 && s[y - skip][x] == '.') {
					skip++;
				}
				if (y - skip >= 0) {
					if (s[y - skip][x] == '-') {
						for (int i = y; i > y - skip; i--) {
							s[i][x] = '.';
						}
						skip = 0;
						y = y - skip;
					} else {
						s[y][x] = s[y - skip][x];
					}
				} else {
					s[y][x] = '.';
				}
			}
		}
		return s;
	}

	public static int score(char[][] s) {
		boolean[][] checked = new boolean[s.length][s[0].length];
		int oMax = 0;
		int xMax = 0;
		for (int y = 0; y < s.length; y++) {
			for (int x = 0; x < s[y].length; x++) {
				char current = s[y][x];
				if (current == 'o') {
					int score = score(s, checked, current, x, y);
					if (oMax < score) {
						oMax = score;
					}
				} else if (current == 'x') {
					int score = score(s, checked, current, x, y);
					if (xMax < score) {
						xMax = score;
					}
				}
			}
		}

		return oMax + xMax;
	}

	private static int score(char[][] s, boolean[][] checked, char current, int x, int y) {
		if (s[y][x] != current) {
			return 0;
		}

		checked[y][x] = true;

		int sum = 1;
		if (x - 1 >= 0 && !checked[y][x - 1]) {
			sum += score(s, checked, current, x - 1, y);
		}
		if (y - 1 >= 0 && !checked[y - 1][x]) {
			sum += score(s, checked, current, x, y - 1);
		}
		if (x + 1 < s[y].length && !checked[y][x + 1]) {
			sum += score(s, checked, current, x + 1, y);
		}
		if (y + 1 < s.length && !checked[y + 1][x]) {
			sum += score(s, checked, current, x, y + 1);
		}

		return sum;
	}

	private static boolean isDebug = System.getProperty("sun.desktop") != null;

	private static void debug(Object... o) {
		if (isDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}
}

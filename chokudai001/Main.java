import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	private static final int MATRIX_SIZE = 30;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[MATRIX_SIZE][];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[MATRIX_SIZE];
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		int prevX = 0;
		int prevY = 0;

		while (true) {
			boolean found = false;
			int maxDiff = Integer.MIN_VALUE;
			int score = -1;
			int x = 0;
			int y = 0;

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					int xx = (i + prevX) % MATRIX_SIZE;
					int yy = (j + prevY) % MATRIX_SIZE;

					int diff = Integer.MAX_VALUE;
					if (xx > 0) {
						diff = Math.min(diff, matrix[xx][yy] - matrix[xx - 1][yy]);
					}
					if (xx < MATRIX_SIZE - 1) {
						diff = Math.min(diff, matrix[xx][yy] - matrix[xx + 1][yy]);
					}
					if (yy > 0) {
						diff = Math.min(diff, matrix[xx][yy] - matrix[xx][yy - 1]);
					}
					if (yy < MATRIX_SIZE - 1) {
						diff = Math.min(diff, matrix[xx][yy] - matrix[xx][yy + 1]);
					}

					if (matrix[xx][yy] > 0 && maxDiff < diff) {
						found = true;
						maxDiff = diff;
						score = matrix[xx][yy];
						x = xx;
						y = yy;
					}
				}
			}

			if (!found) {
				break;
			}

			prevX = x;
			prevY = y;

			boolean first = true;

			while (true) {
				output(x, y);
				matrix[x][y]--;

				debug(x, y, matrix, first);
				first = false;

				if (matrix[x][y] == 0) {
					break;
				}

				if (x > 0 && matrix[x][y] == matrix[x - 1][y]) {
					x--;
					continue;
				}
				if (y > 0 && matrix[x][y] == matrix[x][y - 1]) {
					y--;
					continue;
				}
				break;
			}
		}

		System.out.println();
	}

	private static void output(int x, int y) {
		System.out.println((x + 1) + " " + (y + 1));
	}

	private static void debug(int x, int y, int[][] matrix, boolean first)
		throws FileNotFoundException {
		try (PrintStream output = new PrintStream(
			new FileOutputStream("C:\\Users\\Yuzi\\Desktop\\output.log", true))) {
			output.println((x + 1) + " " + (y + 1) + " " + (first ? "1" : "0"));
		}
	}
}

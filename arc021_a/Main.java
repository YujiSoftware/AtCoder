import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if ((i < 3 && matrix[i][j] == matrix[i + 1][j])
						|| (j < 3 && matrix[i][j] == matrix[i][j + 1])) {
					System.out.println("CONTINUE");
					return;
				}
			}
		}

		System.out.println("GAMEOVER");
	}
}

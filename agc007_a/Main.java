import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		char[][] A = new char[H][W];
		for (int i = 0; i < H; i++) {
			A[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < H - 1; i++) {
			for (int j = 0; j < W - 1; j++) {
				if (A[i][j + 1] == '#' && A[i + 1][j] == '#') {
					System.out.println("Impossible");
					return;
				}
			}
		}

		System.out.println("Possible");
	}

	public static class Route {
		public List<Position> route = new ArrayList<>();

		public Route(List<Position> prev, Position next) {
			route = new ArrayList<>(prev);
			route.add(next);
		}

		public Position getLast() {
			return route.get(route.size() - 1);
		}
	}

	public static class Position {
		public int x;
		public int y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}
}

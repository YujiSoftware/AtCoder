import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	// Reference:
	// 点と三角形の当たり判定 (内外判定)
	// http://www.sousakuba.com/Programming/gs_hittest_point_triangle.html

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			points[i] = new Point(sc.nextInt(), sc.nextInt());
		}

		if (N % 2 == 1) {
			System.out.println(-1);
			return;
		}

		List<Point> result = new ArrayList<>();

		Point A = new Point(0, 0);
		Point B;

		B = new Point(0, H);
		for (int i = 0; i < W; i++) {
			Point C = new Point(i, H);

			Point ab = B.minus(A);
			Point bc = C.minus(B);
			Point ca = A.minus(C);

			int inner = 0;
			for (Point P : points) {
				Point ap = P.minus(A);
				Point bp = P.minus(B);
				Point cp = P.minus(C);

				double c1 = ab.x * bp.y - ab.y * bp.x;
				double c2 = bc.x * cp.y - bc.y * cp.x;
				double c3 = ca.x * ap.y - ca.y * ap.x;

				if ((c1 > 0 && c2 > 0 && c3 > 0 || c1 < 0 && c2 < 0 && c3 < 0)) {
					inner++;
				}
			}

			if (N / 2 == inner) {
				result.add(C);
			}
		}

		B = new Point(W, 0);
		for (int i = 0; i <= H; i++) {
			Point C = new Point(W, i);

			Point ab = B.minus(A);
			Point bc = C.minus(B);
			Point ca = A.minus(C);

			int inner = 0;
			for (Point P : points) {
				Point ap = P.minus(A);
				Point bp = P.minus(B);
				Point cp = P.minus(C);

				double c1 = ab.x * bp.y - ab.y * bp.x;
				double c2 = bc.x * cp.y - bc.y * cp.x;
				double c3 = ca.x * ap.y - ca.y * ap.x;

				if ((c1 > 0 && c2 > 0 && c3 > 0 || c1 < 0 && c2 < 0 && c3 < 0)) {
					inner++;
				}
			}

			if (N / 2 == inner) {
				result.add(C);
			}
		}

		if (result.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(result);

			for (Point p : result) {
				System.out.format("(%d,%d)%s", p.x, p.y, System.lineSeparator());
			}
		}
	}

	public static class Point implements Comparable<Point> {
		public int x;
		public int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point minus(Point p) {
			return new Point(this.x - p.x, this.y - p.y);
		}

		@Override
		public int compareTo(Point o) {
			if (this.x != o.x) {
				return this.x - o.x;
			} else {
				return this.y - o.y;
			}
		}
	}

}

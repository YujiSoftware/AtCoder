import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<List<Integer>> map = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			map.get(A).add(B);
			map.get(B).add(A);
		}

		for (int i = 1; i <= N; i++) {
			Set<Integer> friendFriend = new HashSet<Integer>();

			for (int friend : map.get(i)) {
				friendFriend.addAll(map.get(friend));
			}

			// 自分を除外
			friendFriend.remove(i);
			// 友達を除外
			friendFriend.removeAll(map.get(i));

			System.out.println(friendFriend.size());
		}

	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sum = 0;
		Map<Integer, List<String>> map = new HashMap<>();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int value = i * j;
				sum += value;

				List<String> list = map.get(value);
				if (list == null) {
					list = new ArrayList<>();
					map.put(value, list);
				}
				list.add(i + " x " + j);
			}
		}

		for (String str : map.get(sum - N)) {
			System.out.println(str);
		}
	}
}

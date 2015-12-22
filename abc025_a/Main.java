import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int N = sc.nextInt();

		List<String> nickName = new ArrayList<String>();
		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				nickName.add(S.substring(i, i + 1) + S.substring(j, j + 1));
			}
		}

		System.out.println(nickName.get(N - 1));
	}
}
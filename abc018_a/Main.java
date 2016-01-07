import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		List<Integer> num = new ArrayList<Integer>(Arrays.asList(A, B, C));
		Collections.sort(num, Collections.reverseOrder());

		System.out.println(num.indexOf(A) + 1);
		System.out.println(num.indexOf(B) + 1);
		System.out.println(num.indexOf(C) + 1);
	}
}

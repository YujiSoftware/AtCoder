import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		String text = "DiscoPresentsDiscoveryChannelProgrammingContest2016";

		for (int i = 0; i < text.length(); i += W) {
			System.out.println(text.substring(i, Math.min(i + W, text.length())));
		}
	}
}

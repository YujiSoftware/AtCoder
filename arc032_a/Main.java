import java.math.BigInteger;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger sum = BigInteger.valueOf((n * (n + 1)) / 2);
		System.out.println(sum.isProbablePrime(Integer.MAX_VALUE) ? "WANWAN" : "BOWWOW");
	}
}

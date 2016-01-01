import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int num = Integer.parseInt(A + B);
		
		System.out.println(num * 2);
	}
}

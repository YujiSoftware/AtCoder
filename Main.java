import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int resultA = max(a) - b;
		int resultB = a - min(b);
		
		int reuslt = Math.max(resultA, resultB);
		
		System.out.println(reuslt);
	}
	
	private static int max(int value){
		if(value >= 990){
			return 999;
		}else if(value >= 900){
			return 990 + (value %10);
		}else{
			return 900 + (value % 100);
		}
	}
	
	private static int min(int value){
		if(value < 110){
			return 100;
		}else if(value < 200){
			return 100 + (value % 10);
		}else{
			return 100 + (value % 100);
		}
	}
	
}

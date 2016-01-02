import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		
		char prev = S.charAt(0);
		int count = 1;
		
		StringBuilder result = new StringBuilder();
		for(int i = 1; i < S.length(); i++){
			char c = S.charAt(i);
			
			if(prev == c){
				count++;
			}else{
				result.append(prev);
				result.append(count);
				
				prev = c;
				count = 1;
			}
		}
		
		result.append(prev);
		result.append(count);
		
		System.out.println(result.toString());
	}
}

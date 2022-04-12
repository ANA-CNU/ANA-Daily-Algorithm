import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		int n=word.length();
		int result=1;
		for(int i=0;i<=(n-1)/2;i++) {
			if(word.charAt(i)!=word.charAt(n-i-1)) {
				result=0;
				break;
			}
		}
		System.out.println(result);
	}

}

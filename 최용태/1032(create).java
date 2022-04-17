import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		String first=sc.next();
		char[] currentstr=first.toCharArray();
		
		for(int i=1;i<N;i++) {
			String buf=sc.next();
			char[] cmpstr=buf.toCharArray();
			for(int j=0;j<buf.length();j++) {
				if(cmpstr[j]!=currentstr[j])
					currentstr[j]='?';
			}
		}
		for(int i=0;i<first.length();i++)
			System.out.print(currentstr[i]);
	}
}
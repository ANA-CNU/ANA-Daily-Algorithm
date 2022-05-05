import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String t=sc.nextLine();
		int n=Integer.parseInt(t);
		for(int i=0;i<n;i++) {
			String tmp=sc.nextLine();
			String[] s=tmp.split(" ");
			int k=Integer.parseInt(s[0]);
			for(int l=0;l<s[1].length();l++) {
				for(int j=0;j<k;j++) {
					System.out.print(s[1].charAt(l));
				}
			}
			System.out.println();
			
		}

	}

}

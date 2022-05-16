import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		char[] al=new char[26];
		int[] count=new int[26];
		for(int i=0;i<=25;i++) {
			al[i]=(char)(i+'a');
			count[i]=0;
		}
		for(int i=0;i<n;i++) {
			String tmp=sc.nextLine();
			for(int j=0;j<26;j++) {
				if(tmp.charAt(0)==al[j]) {
					count[j]++;
				}
			}
			
		}
		int can=0;
		for(int i=0;i<26;i++) {
			if(count[i]>=5) {
				System.out.print(al[i]);
				can=1;
			}
		}
		if(can==0) {
			System.out.println("PREDAJA");
		}
	}

}

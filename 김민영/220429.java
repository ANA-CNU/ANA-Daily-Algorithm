import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char[] alphabet=new char[26];
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<26;i++) {
			alphabet[i]=(char)('A'+i);
		}
		int can=0;
		int[] count=new int[26];
		while(true) {
			can=0;
			way:
			Arrays.fill(count,0);
			String tmp=sc.nextLine();
			if(tmp.equals("END")) break;
			for(int i=0;i<tmp.length();i++) {
				for(int j=0;j<26;j++) {
					if(tmp.charAt(i)==alphabet[j]) {
						count[j]++;
					}
				}
			}
			for(int k=0;k<26;k++) {
				if(count[k]>=2) {
					can=1;
				}
			}
			if(can==0) {
				sb.append(tmp);
				sb.append("\n");
			}
			
		}
		System.out.println(sb);

	}

}

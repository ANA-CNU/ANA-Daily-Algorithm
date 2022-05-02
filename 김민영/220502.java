import java.util.Arrays;
import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		int n=Integer.parseInt(word);
		for(int i=0;i<n;i++) {
			String cookie=sc.nextLine();
			int[] isUsed=new int[cookie.length()];
			Arrays.fill(isUsed, 1);
			String count1=sc.nextLine();
			int count=Integer.parseInt(count1);
			for(int j=0;j<count;j++) {
				int okay=0;
				Arrays.fill(isUsed, 1);
				String tmp=sc.nextLine();
				for(int p=0;p<tmp.length();p++) {
					for(int q=0;q<cookie.length();q++) {
						if(tmp.charAt(p)==cookie.charAt(q)&&isUsed[q]==1){
							isUsed[q]=0;
							okay++;
							break;
						}
					}
				}
				if(okay==tmp.length()) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}

	}

}

import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] num=new int[30];
		int[] count=new int[30];
		Arrays.fill(count, 0);
		for(int i=1;i<=30;i++) {
			num[i-1]=i;
		}
		for(int i=0;i<28;i++) {
			int tmp=sc.nextInt();
			for(int j=0;j<num.length;j++) {
				if(tmp==num[j])
				{
					count[j]++;
				}
				}
		}
		for(int k=0;k<30;k++) {
			if(count[k]==0) {
				System.out.println(k+1+" ");
			}
		}
		
	}

}

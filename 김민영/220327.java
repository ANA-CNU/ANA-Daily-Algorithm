import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int A,B,max=-120000000,bae;
		for(int i=0;i<n;i++) {
			A=sc.nextInt();
			B=sc.nextInt();
			for(int j=1;j<A+1;j++) {
				if(A%j==0) {
					if(B%j==0) {
						if(j>max) {
							max=j;
						}
					}
				}
				
				
			}
			bae=max*(A/max)*(B/max);
			System.out.printf("%d %d\n",bae,max);
			max=-1200000000;
		}
		

	}

}

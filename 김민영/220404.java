import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int A,B,max=-100000;
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
		int bae=max*(A/max)*(B/max);
		System.out.printf("%d\n%d",max,bae);
			
	}

}

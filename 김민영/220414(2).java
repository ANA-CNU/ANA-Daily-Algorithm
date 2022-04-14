import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		int[] ing=new int[n];
		double[] one=new double[n];
		for(int i=0;i<n;i++) {
			ing[i]=sc.nextInt();
		}
		for(int j=0;j<n;j++) {
			if(ing[j]%x==0) {
				System.out.println((int)((double)(ing[j]*(double)y)/x));
			}
			else {
				System.out.println((int)((double)(ing[j]*(double)y)/x));
			}
		}	
	}

}

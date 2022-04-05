import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int n, max=-1;
		for(int i=0;i<T;i++) {
			n=sc.nextInt();
			while(true) {
				if(n==1) {
					if(n>max) {
						max=n;
					}
					break;
				}
				else if(n%2==0) {
					if(n>max) {
						max=n;
					}
					n=n/2;
				}
				else {
					if(n>max) {
						max=n;
					}
					n=n*3+1;
				}
			}
			System.out.println(max);
			max=-1;
		}

	}

}

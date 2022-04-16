import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int min=10001,result=0;
		for(int i=m;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(i/j==j&&i%j==0) {
					result=result+i;
					if(min>i) {
						min=i;
					}
				}
			}
		}
		if(min==10001&&result==0) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
			System.out.println(min);
		}
		
	}

}

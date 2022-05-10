import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int r=fact(n)/(fact(k)*fact(n-k));
		System.out.println(r);
		sc.close();
	}
		static int fact(int a) {
		int result=a;
		if(a<=1) return 1;
		else {
			result=result*fact(a-1);
			return result;
		}
	}

}

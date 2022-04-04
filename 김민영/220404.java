import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int n,m,k,result;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
		if(n/2>m) {
			result=m;
		}
		else {
			result=n/2;
		}
		while(true) {
			if(n+m-result*3>=k) {
				break;
			}
			else {
				result--;
			}
		}
		System.out.println(result);
	}

}

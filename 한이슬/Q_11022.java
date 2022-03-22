import java.util.Scanner;

public class Q_11022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,a,b;
		n=sc.nextInt();
		for (int i=1; i<=n; i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			System.out.printf("Case #%d: %d + %d = %d"+"\n",i,a,b,a+b);
		}
	}

}

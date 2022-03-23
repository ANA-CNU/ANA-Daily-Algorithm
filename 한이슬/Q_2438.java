import java.util.Scanner;
public class Q_2438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=0;
		n=sc.nextInt();
		for(int i=1; i<=n; i++) {
			for (int j=1; j<(i+1); j++) {
				System.out.print("*");
			}
		System.out.println("");
		}
	}

}

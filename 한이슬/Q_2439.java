import java.util.Scanner;

public class Q_2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 0;
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}

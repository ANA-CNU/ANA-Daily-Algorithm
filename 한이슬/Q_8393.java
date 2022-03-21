import java.util.Scanner;

public class Q_8393 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int sum = 0;
		n = sc.nextInt();
		for (int i=1; i <= n; i++) {
			sum += i;
			// System.out.printf("i=%d, sum=%d" + "\n",i,sum);
		}
		System.out.println(sum);
	}

}

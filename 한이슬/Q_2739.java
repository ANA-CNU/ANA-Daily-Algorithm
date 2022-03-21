import java.util.Scanner;

public class Q_2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = 0;
		N = sc.nextInt();
		for (int i =1; i<10; i++) {
			System.out.printf("%d * %d = %d" + "\n", N, i, N*i);
			}
	}

}
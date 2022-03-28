import java.util.*;

public class Q_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = 0;
		N = sc.nextInt();
		int count = 0;
		int a = 0, b = 0, c = 0, d = 0;
		if (N >= 10) {
			count += 1;
			a = (N % 10);
			b = (N / 10) + (N % 10); // N=26, 2+6=08
			c = (N % 10) * 10 + b % 10;
			while (true) {
				count += 1;
				d = c / 10 + c % 10;
				c = (c % 10) * 10 + d % 10;
				if (N == c) {
					break;
				}
			}
		} else if (N > 0 && N <= 10) {
			count += 1;
			c = 10 * N + N;
			while (true) {
				count += 1;
				d = c / 10 + c % 10;
				c = (c % 10) * 10 + d % 10;
				if (N == c) {
					break;
				}
			}
		} else if (N==0) {
			count += 1;
		}
		System.out.println(count);
	}

}

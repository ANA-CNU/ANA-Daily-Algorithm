import java.util.Arrays;
import java.util.Scanner;

public class Q_4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = 0, sum;
		double mean = 0, count=0;
		int arr[];
		for (int i = 0; i < n; i++) {
			sum = 0;
			count = 0;
			k = sc.nextInt();
			int num = k;
			arr = new int[k];
			for (int j = 0; j < arr.length; j++) {
				int s = sc.nextInt();
				arr[j] = s;
				sum += s;
				mean = sum / k;
			}
			for (int m = 0; m < arr.length; m++) {
				if (arr[m] > mean) {
					count += 1;
				}
			}
			System.out.printf("%.3f%%\n", (count / k) * 100);
		}
	}
}

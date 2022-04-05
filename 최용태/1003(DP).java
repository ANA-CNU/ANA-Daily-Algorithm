import java.util.Scanner;

public class Main {

	static int count1;
	static int count0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int total1 = 0, total0 = 0;
		int tmp1 = 0, tmp0 = 0;
		int ttmp1 = 0, ttmp0 = 0;

		for (int j = 0; j < T; j++) {
			int N = sc.nextInt();
			if (N < 2) {
				if (N == 0) {
					total1 = 0;
					total0 = 1;
				}
				else if (N == 1) {
					total0=0;
					total1 = 1;
				}
			} else {
				total1 = 1;
				tmp1 = 1;
				total0 = 1;
				tmp0 = 1;

				ttmp1 = 1;
				ttmp0 = 0;
				for (int i = 2; i < N; i++) {
					total1 = tmp1 + ttmp1;
					total0 = tmp0 + ttmp0;

					ttmp1 = tmp1;
					tmp1 = total1;
					ttmp0 = tmp0;
					tmp0 = total0;
				}
			}
			System.out.println(total0 + " " + total1);
		}
	}
}
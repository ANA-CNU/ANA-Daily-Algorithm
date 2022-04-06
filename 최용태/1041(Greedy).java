import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		int[] dice = new int[6];
		int t = 0, tt = 0, ttt = 0;
		int least = 0;
		if (N == 1) {
			int result1 = 0;
			int largest = 0;
			for (int i = 0; i < 6; i++) {
				dice[i] = sc.nextInt();
				result1 += dice[i];
				if (dice[i] > dice[largest])
					largest = i;
			}
			result1 -= dice[largest];
			System.out.println(result1);
		} else {
			
			for (int i = 0; i < 6; i++)
				dice[i] = sc.nextInt();
			
			if (dice[0] < dice[5])
				t = 0;
			else
				t = 5;
			for (int i = 0; i < 4; i++) {
				int cmp = 0;
				if (i == 0) {
					least = dice[1] + dice[2];
					if (dice[1] < dice[2]) {
						tt = 1;
						ttt = 2;
					} else {
						tt = 2;
						ttt = 1;
					}
					continue;
				}
				switch (i) {
				case 1:
					cmp = dice[3] + dice[4];
					if (cmp < least) {
						least = cmp;
						if (dice[3] < dice[4]) {
							tt = 3;
							ttt = 4;
						} else {
							tt = 4;
							ttt = 3;
						}
					}
					break;
				case 2:
					cmp = dice[2] + dice[4];
					if (cmp < least) {
						least = cmp;
						if (dice[2] < dice[4]) {
							tt = 2;
							ttt = 4;
						} else {
							tt = 4;
							ttt = 2;
						}
					}
					break;
				case 3:
					cmp = dice[1] + dice[3];
					if (cmp < least) {
						least = cmp;
						if (dice[1] < dice[3]) {
							tt = 1;
							ttt = 3;
						} else {
							tt = 3;
							ttt = 1;
						}
					}
					break;
				default:
					break;
				}
			}

			if(dice[t]>dice[tt]) {
				int tmp=dice[t];
				dice[t]=dice[tt];
				dice[tt]=tmp;
			}
			if(dice[tt]>dice[ttt])
			{
				int tmp=dice[tt];
				dice[tt]=dice[ttt];
				dice[ttt]=tmp;
			}

			long a = dice[t] * N * N; // int 끼리의 곱==int값으로 저장 후 long으로 인식하여 오버플로우?
			long b = 4 * (dice[tt] + dice[ttt]) + ((4 * N - 8) * dice[tt]);
			long c = (N - 1) * (4 * (dice[t] + dice[tt]) + (4 * N - 8) * dice[t]);

			long result = a + b + c;
			System.out.println(result);
		}
	}
}
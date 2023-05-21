package bj;

import java.util.Scanner;

public class 백준_14492번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] a = new int[302][302];
		int[][] b = new int[302][302];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean tmp = false;
				for (int m = 0; m < n; m++) {
					tmp |= a[i][m] != 0 && b[m][j] != 0;

					if (tmp) {
						cnt++;
						break;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}

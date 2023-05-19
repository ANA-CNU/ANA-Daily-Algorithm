package bj;

import java.util.Scanner;

public class 백준_2740번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt(), m = sc.nextInt();
		int[][] list = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < m; k++) {
				list[i][k] = sc.nextInt();
			}
		}
		int a = sc.nextInt(), b = sc.nextInt();
		int[][] list2 = new int[a][b];
		for (int i = 0; i < a; i++) {
			for (int k = 0; k < b; k++) {
				list2[i][k] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < b; j++) {
				int sum = 0;
				for (int k = 0; k < a; k++) {
					sum += list[i][k] * list2[k][j];
				}
				sb.append(sum).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}

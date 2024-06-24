package baekjoon2024June;

import java.util.*;
public class n10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] arr = new long[101][10];
		
		for(int i = 1; i<=9; i++) {
			arr[1][i] = 1;
		}
		for(int i =2; i<=n; i++) {
			for(int j = 0; j<=9; j++) {
				if(j==0) {
					arr[i][j] = arr[i-1][1];
				}
				else if(j == 9) {
					arr[i][j] = arr[i-1][8];
				}
				else {
					arr[i][j] = (arr[i-1][j+1] + arr[i-1][j-1])%1000000000;
				}
			}
		}
		long sum = 0;
		for(int i = 0; i<=9; i++) {
			sum+=arr[n][i];
		}
		System.out.println(sum%1000000000);
	}
}

package beakjoon;

import java.util.Scanner;

public class 계단_오르기_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());

		int arr[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		
		
		int s[] = new int[n+1];
		
		//s[1]
		s[1] = arr[1];
		
		//s[2]
		if(n>=2) {
			s[2] = arr[1]+arr[2];
		}

		//s[3] ~ s[n]
		for(int i=3; i<=n; i++) {
			s[i] = Math.max(s[i-3]+arr[i-1]+arr[i], s[i-2]+arr[i]);
		}
		
		System.out.println(s[n]);
	}
}
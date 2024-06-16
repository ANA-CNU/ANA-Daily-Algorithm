package baekjoon2024June;

import java.util.Scanner;

public class n1124 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = (int)Math.sqrt((double)b);
		boolean[] prime = new boolean[n + 1];
		prime[1] = true;
		for(int i = 2; i<=n; i++) {
			if(!prime[i]) {
				for(int j = 2*i; j<=n; j+=i) {
					prime[j] = true;
				}
			}
		}
		int sum = 0;
		for(int i = a; i<=b; i++) {
			int s = i;
			int num = 0;
			while( s!= 1) {
				boolean check = false;
				for(int j = 2; j<= Math.sqrt(s); j++) {
					if(s%j == 0) {
						s /=j;
						num++;
						check = true;
						break;
					}
				}
				if(!check) {
					num++; 
					break;
				}
			}
			//System.out.println(num);
			if(!prime[num]) {
				sum++;
				//System.out.println(i);
			}
		}
		System.out.println(sum);
	}
}

package 하루하나;

import java.util.Scanner;

public class 백준_2018번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum =0;
		
		for(int i=1;i<=n;i++) {
			int tmp =0;
			for(int k=i;k<=n;k++) {
				tmp+=k;
				if(tmp>n)
					break;
				else if(tmp==n) {
					sum++;
					break;
				}
			}
		}
		System.out.println(sum);
	}
}

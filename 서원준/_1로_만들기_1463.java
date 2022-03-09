package beakjoon;

import java.util.Scanner;

public class _1로_만들기_1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int arr[] = new int[n+1];
		
		arr[0] = 0;
		
		for(int i=2; i<=n; i++) {
			arr[i] = arr[i-1]+1;	// #3 -1
			if(i%2==0) {	//#1 ÷2
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
			if(i%3==0) {	//#2 ÷3
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
		}
		System.out.println(arr[n]);
	}
}

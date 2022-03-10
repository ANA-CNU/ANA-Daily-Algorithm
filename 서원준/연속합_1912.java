package beakjoon;

import java.util.Scanner;

public class 연속합_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		String a[] = sc.nextLine().split(" ");
		int arr[] = new int[n];
		for(int i=0; i<a.length; i++) {
			arr[i] = Integer.parseInt(a[i]);
		}
		
		int d[] = new int[n];
		
		
		for(int i=1; i<n; i++) {
			arr[i] = Math.max(arr[i], arr[i-1] + arr[i]);
		}
		
		int max=arr[0];
		for(int i=1; i<n; i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println(max);
	}
}

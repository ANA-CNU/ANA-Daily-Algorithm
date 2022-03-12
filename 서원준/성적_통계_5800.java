package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 성적_통계_5800 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int k = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<k; i++) {
			String input[] = sc.nextLine().split(" ");
			int n = Integer.parseInt(input[0]);
			
			int arr[] = new int[n];
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(input[j+1]);
			}
			
			Arrays.sort(arr);
			
			int gap = 0;
			for(int j=0; j<n-1; j++) {
				gap = Math.max(gap, arr[j+1]-arr[j]);
			}
			
			System.out.println("Class "+ (i+1));
			System.out.println("Max "+ arr[n-1] +", Min "+ arr[0] +", Largest gap "+gap);
		}

	}

}

package first;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		int arr[] = new int[10];
		int num[] = new int[T];
		
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < 10; j++) {
				arr[j] = input.nextInt();
			}
			Arrays.sort(arr);
			num[i] = arr[7];
		}
	
		for(int i = 0; i < T; i++) {
			System.out.println(num[i]);
		}
	}
}



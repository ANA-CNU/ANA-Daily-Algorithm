package first;

import java.util.Scanner;
import java.util.Arrays;

public class 1978 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int arr[] = new int[1001];
		int N[] = new int[input.nextInt()];
		int num = 0;
		
		for(int i = 0; i <= 1000; i++) {
			arr[i] = -1;
		}
		
		for(int i = 0; i < N.length; i++) {
			N[i] = input.nextInt();
		}
		
		Arrays.sort(N);
		
		for(int i = 0; i < N.length; i++) {
			arr[N[i]]++;
		}
		
		for(int j = 1; j <= N[N.length-1]; j++) {
			for(int i = 1; i <= j; i++) {
					if((arr[j] == 0)||(arr[j] == 1)||(arr[j] == 2)) {
						if(j%i == 0) {
							arr[j]++;
						}
					}
				}			
			}
	
		for(int i = 0; i <= N[N.length-1]; i++) {
			if(arr[i] == 2)
				num++;
			}
		
		System.out.println(num);
		
		}
	}
		
		



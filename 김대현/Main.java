import java.util.Arrays;
import java.util.Scanner;


public class Main {	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int arr[] = new int[9];
		int hap = 0;
		int temp = 0;
		int nan1 = 0;
		int nan2 = 0;
		
		for(int i = 0; i < 9; i++) {
			arr[i] = input.nextInt();
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j <8-i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
						
		for(int i = 0; i < 9; i++) {
			hap += arr[i];
		}
		
		hap = hap-100;
		
		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if((arr[i]+arr[j]) == hap) {
					nan1 = i;
					nan2 = j;
				}
			}
		}
				
		for(int i = 0; nan1+i < 8; i++) {
			arr[nan1+i] = arr[nan1+i+1];
		}
		
		for(int i = 0; nan2+i < 8; i++) {
			arr[nan2+i-1] = arr[nan2+i];
		}
						
		for(int i = 0; i < 7; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
	
	
	




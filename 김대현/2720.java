import java.util.Scanner;


public class 2720 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		int[] arr= new int[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = 0;
		}
		
		

		for(int i = 0; i < num; i++) {			
			arr[i] = input.nextInt();
			}
		
		
		
		for(int i = 0; i < num; i++) {
			System.out.print(arr[i]/25+" ");
			arr[i] %= 25;
			System.out.print(arr[i]/10+" ");
			arr[i] %= 10;
			System.out.print(arr[i]/5+" ");
			arr[i] %= 5;
			System.out.println(arr[i]/1+" ");
		}
		}
	}




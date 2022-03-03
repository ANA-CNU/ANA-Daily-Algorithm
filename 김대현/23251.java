import java.util.Scanner;


public class 23251 {
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
			System.out.println(arr[i]*23);		
			}
		}
	}




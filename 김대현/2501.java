import java.util.Scanner;


public class 2501 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int K = input.nextInt();
		
		int num = input.nextInt();
		
		int target = 0;
		
		for(int i = 1; i <= K; i++) {
			if(K%i == 0) {
				target++;
			}
			if(target == num) {
				System.out.println(i);
				break;
			}
				}
			
		if(target < num)
			System.out.println("0");
		}
	}




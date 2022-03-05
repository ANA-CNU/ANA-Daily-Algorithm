import java.util.Scanner;


public class 3460 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		int Ori[] = new int[num];
		
		for(int i = 0; i < num; i++) {
			Ori[i] = input.nextInt();
		}
		
		int[][] arr = new int[num][24];
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < 24; j++) {
				arr[i][j] = 9;
			}
		}
		
		for(int i = 0; i < num; i++) {
			int j = 0;
			while(Ori[i] != 1) {
				arr[i][j] = Ori[i]%2;
				Ori[i] /= 2;
				j++;
			}
			arr[i][j] = 1;
		}
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; arr[i][j] != 9; j++) {
				if(arr[i][j] == 1)
				System.out.print(j+" ");
				}
			}
			System.out.println();
		}		
		}
	




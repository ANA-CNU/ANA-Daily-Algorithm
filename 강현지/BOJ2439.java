package BOJ1008;
import java.util.Scanner;

public class BOJ2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = N; i>0;i--) {
			for(int j = 1;j<=N; j++) {
				if(j<i){
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
			
		}

	}

}

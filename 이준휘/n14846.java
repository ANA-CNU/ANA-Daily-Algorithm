package baekjoon;
import java.util.Scanner;
public class n14846 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] A = new int[N+1][N+1];
		int[][][] S = new int[N+1][N+1][10];
		for(int i =1; i<=N; i++) {
			for(int j = 1; j<=N ; j++) {
				A[i][j] = sc.nextInt();
				for(int k = 1; k<=9; k++) {
					S[i][j][k]=S[i][j-1][k]+S[i-1][j][k]-S[i-1][j-1][k];
				}
				S[i][j][A[i][j]]++;
			}
		}
		int Q = sc.nextInt();
		int sum = 0;
		for(int i = 0; i<Q; i++) {
			sum=0;
			int X1 = sc.nextInt();
			int Y1 = sc.nextInt();
			int X2 = sc.nextInt();
			int Y2 = sc.nextInt();
			for(int j=1; j<=9; j++) {
				if(S[X2][Y2][j]-S[X2][Y1-1][j]-S[X1-1][Y2][j]+S[X1-1][Y1-1][j]>0) {
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
}

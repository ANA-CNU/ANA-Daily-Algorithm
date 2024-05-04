package baekjoon;
import java.util.Scanner;
public class n1089 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] N = new char[5][10000];
		String[] K = new String[5];
		int num = sc.nextInt();
		String Buffer = sc.nextLine();
		for(int i = 0; i<5; i++) {
			K[i] = sc.nextLine();
		}
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<num*4-1; j++) {
				N[i][j] = K[i].charAt(j);
			}
		}
		for(int i = 0; i<num; i++) {
			if(N[1][4*i+1] == '#' || N[3][4*i+1] == '#') {
				System.out.println(-1);
				return;
			}
		}
		
		boolean[][] S = new boolean[num+1][10];
		for(int i=0; i<=num; i++) {
			for(int j=0; j<=9; j++) {
				S[i][j]=true;
			}
		}
		
		for(int i = 0; i<num; i++) {
			if(N[0][i*4]=='#') {
				S[i+1][1]=false;
			}
			if(N[0][i*4+1]=='#') {
				S[i+1][1]=false;
				S[i+1][4]=false;
			}
			if(N[1][i*4]=='#') {
				S[i+1][1]=false;
				S[i+1][2]=false;
				S[i+1][3]=false;
				S[i+1][7]=false;
			}
			if(N[1][i*4+2]=='#') {
				S[i+1][5]=false;
				S[i+1][6]=false;
			}
			if(N[2][i*4]=='#') {
				S[i+1][1]=false;
				S[i+1][7]=false;
			}
			if(N[2][i*4+1]=='#') {
				S[i+1][0]=false;
				S[i+1][1]=false;
				S[i+1][7]=false;
			}
			if(N[3][i*4]=='#') {
				S[i+1][1]=false;
				S[i+1][3]=false;
				S[i+1][4]=false;
				S[i+1][5]=false;
				S[i+1][7]=false;
				S[i+1][9]=false;
			}
			if(N[3][i*4+2]=='#') {
				S[i+1][2]=false;
			}
			if(N[4][i*4]=='#') {
				S[i+1][1]=false;
				S[i+1][4]=false;
				S[i+1][7]=false;
			}
			if(N[4][i*4+1]=='#') {
				S[i+1][1]=false;
				S[i+1][4]=false;
				S[i+1][7]=false;
			}
		}
		
		int T=0;
		long[] sum_T= new long[num+1];
		long[] sum= new long[num+1];
		for(int i=1; i<=num; i++) {
			for(int j=0; j<10; j++) {
				if(S[num-i+1][j]) {
					sum[i]+=j;
					sum_T[i]+=1;
				}
			}
		}
		
		int result=0;
		
		for(int i=1; i<=num; i++) {
			int ten=1;
			for(int j= 1; j<i; j++) {
				ten*=10;
			}
			sum[i]*=ten;
			
			for(int j=1; j<=num;j++) {
				int B=1;
				if(j!=i) {
					B*=sum_T[j];
				}
				sum[i]*=B;
				//System.out.println(sum[i]);
			}
		}
		
		long summ=0;
		for(int i = 1; i<=num; i++) {
			summ+=sum[i];
		}
		int G=1;
		for(int i=1; i<=num; i++) {
			G*=sum_T[i];
		}
		System.out.printf("%f", (double)summ/G);
		
	}
}

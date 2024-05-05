package baekjoon;
import java.util.Scanner;
public class n1041 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long NUM = sc.nextLong();
		long[] N=new long[7];
		for(int i=1; i<=6; i++) {
			N[i]=sc.nextLong();
		}
		long[] Adge = new long[13];
		Adge[1]=N[1]+N[2];
		Adge[2]=N[1]+N[3];
		Adge[3]=N[1]+N[4];
		Adge[4]=N[1]+N[5];
		Adge[5]=N[2]+N[3];
		Adge[6]=N[2]+N[4];
		Adge[7]=N[2]+N[6];
		Adge[8]=N[3]+N[5];
		Adge[9]=N[3]+N[6];
		Adge[10]=N[4]+N[5];
		Adge[11]=N[4]+N[6];
		Adge[12]=N[5]+N[6];
		long MIN_A=0;
		for(int i=1; i<=12; i++) {
			if(MIN_A>Adge[i] || MIN_A==0) MIN_A=Adge[i];
		}
		long[] P=new long[9];
		P[1]=N[1]+N[2]+N[3];
		P[2]=N[1]+N[2]+N[4];
		P[3]=N[1]+N[3]+N[5];
		P[4]=N[1]+N[4]+N[5];
		P[5]=N[6]+N[2]+N[3];
		P[6]=N[6]+N[2]+N[4];
		P[7]=N[6]+N[3]+N[5];
		P[8]=N[6]+N[4]+N[5];
		long MIN_P=0;
		for(int i=1; i<=8; i++) {
			if(MIN_P>P[i] || MIN_P==0) MIN_P=P[i];
		}
		long MIN_PLANE=0;
		for(int i=1; i<=6; i++) {
			if(MIN_PLANE>N[i] || MIN_PLANE==0) MIN_PLANE=N[i];
		}
		long result=0;
		result=MIN_A*(NUM-2)*4+MIN_A*(NUM-1)*4+MIN_P*4+MIN_PLANE*(NUM-2)*(NUM-2)+MIN_PLANE*(NUM-2)*(NUM-1)*4;
		long sum=N[1]+N[2]+N[3]+N[4]+N[5]+N[6];
		long MIN=0;
		for(int i=1; i<=6; i++) {
			if(MIN>sum-N[i] || MIN==0) MIN=sum-N[i];
		}
		if(NUM==1)System.out.printf("%d", MIN);
		else System.out.print((long)result);
	}
}

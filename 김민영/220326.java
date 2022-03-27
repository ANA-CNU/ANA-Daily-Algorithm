import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int[] arr=new int[n+1];
		int[] sum=new int[n-k+1];
		int tmp=0;
		int max=-1200000000;
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		for(int i=0;i<n-k+1;i++) {
			for(int j=0;j<k;j++) {
				tmp=tmp+arr[i+j];
			}
			sum[i]=tmp;
			tmp=0;
		}
		for(int l=0;l<n-k+1;l++) {
			if(max<sum[l]) {
				max=sum[l];
			}
		}
		System.out.printf("%d",max);		
	}
}

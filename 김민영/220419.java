import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] num=new int[n];
		for(int i=0;i<n;i++) {
			num[i]=sc.nextInt();
		}
		for(int i=0;i<num.length;i++) {
			int isChanged=0;
			for(int j=0;j<num.length-i-1;j++) {
				if(num[j]>num[j+1]) {
					int tmp=num[j];
					num[j]=num[j+1];
					num[j+1]=tmp;
					isChanged=1;
				}
			}
			if(isChanged==0) break;
		}
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}

}

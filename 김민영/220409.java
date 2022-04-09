import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		int length,count=0;
		double result,mean=0,sum=0;
		for(int i=0;i<testCase;i++) {
			length=sc.nextInt();
			count=0;
			sum=0;
			int[] grade=new int[length];
			for(int j=0;j<grade.length;j++) {
				grade[j]=sc.nextInt();
				sum=sum+grade[j];	
			}
			mean=sum/length;
			for(int k=0;k<grade.length;k++) {
				if(grade[k]>mean) {
					count++;
				}
			}
			result=Math.round((count/(double)grade.length)*100*1000)/1000.0;
			System.out.printf("%5.3f%%\n", result);
		}
	}

}

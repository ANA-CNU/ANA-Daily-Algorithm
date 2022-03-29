import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long first=-3,sec=-2,third=-1;
		long result;
		long[] arr=new long[3];
		arr[0]=sc.nextInt();
		arr[1]=sc.nextInt();
		arr[2]=sc.nextInt();
		if((arr[0]==0&&arr[1]==0)||(arr[2]==0&&arr[1]==0)||(arr[0]==0&&arr[2]==0)) {
			System.out.println(arr[0]+arr[1]+arr[2]);
		}
		
		else {
			for(int i=0;i<3;i++) {
				if(arr[i]>first) {
					third=sec;
					sec=first;
					first=arr[i];
					
				}
				else if(arr[i]>sec) {
					third=sec;
					sec=arr[i];
				}
				else {
					third=arr[i];
				}
			}
			if(sec==1&&third==0) {
				System.out.println(first+sec);
			}
			else{
				result=(long)(first*sec+third);
				System.out.println(result);
			}
		}

		
	}

}

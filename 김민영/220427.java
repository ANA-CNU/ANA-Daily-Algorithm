import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		String[] input=new String[n*2];
		for(int i=0;i<n*2;i++) {
			 input[i]=sc.nextLine();
		}
		for(int i=0;i<n*2;i+=2) {
			int min=1000000;
			String[] tmp1=input[i].split(" ");
			String[] tmp2=input[i+1].split(" ");
			for(int k=1;k<=Integer.parseInt(tmp1[0]);k++) {
				int t1=Integer.parseInt(tmp1[k]);
				for(int u=1;u<=Integer.parseInt(tmp2[0]);u++) {
					int t2=Integer.parseInt(tmp2[u]);
					if(Math.abs(t1-t2)<min) {
						min=Math.abs(t1-t2);
					}
				}
			}
			System.out.println(min);
			
		}
		

	}

}

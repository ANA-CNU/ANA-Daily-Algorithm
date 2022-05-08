import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String k=sc.nextLine();
		String[] kk=k.split(" ");
		int t=Integer.parseInt(kk[0]);
		int n=Integer.parseInt(kk[1]);
		int total=0;
		String[] yoil= {"Mon","Tue","Wed","Thu","Fri"};
		
		for(int i=0;i<n;i++) {
			String input=sc.nextLine();
			String[] ip=input.split(" ");
			int start=Integer.parseInt(ip[1]);
			int finish=Integer.parseInt(ip[3]);
			
			if(!(ip[0]).equals(yoil[4])) {
				if(ip[0].equals(ip[2])) {
				total+=finish-start;
				}
				else {
					int s=-1,f=-1;
					for (int j=0;j<5;j++) {
						if(ip[0].equals(yoil[j])) {
							s=j;
						}
						if(ip[2].equals(yoil[j])) {
							f=j;
						}
					}
					total+=24*(f-s)+finish-start;
					}
					
				}
			
			else {
				total+=finish-start;
			}
			}
		if(t<=total) {
			System.out.println(0);
		}
		else if(t-total>48) {
			System.out.println(-1);
		}
		else {
			System.out.println(t-total);
		}

	}

}

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int one=0;
		int zero=0;
		
		for(int j=0;j<3;j++) {
			String n=sc.nextLine();
			for(int i=0;i<n.length();i+=2) {
			if(n.charAt(i)=='0') {
				zero++;
			}
			else {
				one++;
			}
		}
		if(zero==0) {
			System.out.println("E");
		}
		else if(zero==1) {
			System.out.println("A");
		}
		else if(zero==2) {
			System.out.println("B");
		}
		else if(zero==3) {
			System.out.println("C");
		}
		else {
			System.out.println("D");
		}
		zero=0;
		one=0;
		}
		
	}

}

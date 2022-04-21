import java.util.Scanner;

public class Q_2675 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int rep=sc.nextInt();
			String str = sc.next();
			
			int length = str.length();
			for(int j=0; j<length; j++) {
				for(int k=0; k<rep; k++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}

}

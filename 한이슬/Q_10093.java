import java.util.Scanner;

public class Q_10093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		if (a>b) {
			System.out.println(a-b-1);
			for(long i=b+1; i<a; i++) {
				System.out.println(i);
			}
		}
		else if (b>a) {
			System.out.println(b-a-1);
			for(long i=a+1; i<b; i++) {
				System.out.println(i);
			}
		}
		else {System.out.println("0");}
	}

}

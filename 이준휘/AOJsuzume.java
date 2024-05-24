package AOJ;
import java.util.Scanner;
public class AOJsuzume {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long M = 3;
		long S = 3;
		while(N>M) {
			S+=2;
			M+=S;
		}
		System.out.println(S/2);
	}
}

import java.util.Scanner;

public class Q_1712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if ((a/(c-b))>=0) {
			System.out.println((a/(c-b))+1);
		}else {System.out.println("-1");}
	}
}
import java.util.Scanner;

public class Q_2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String x = "";
		String y = "";
		String turna = Integer.toString(a);
		String turnb = Integer.toString(b);
		for (int i = 2; i >= 0; i--) {
			x += turna.charAt(i);
			y += turnb.charAt(i);
		}
		a = Integer.parseInt(x);
		b = Integer.parseInt(y);
		if (a >= b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}
}

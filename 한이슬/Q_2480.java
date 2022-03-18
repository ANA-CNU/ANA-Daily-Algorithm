import java.util.Scanner;

public class Q_2480 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = 0;
		x = sc.nextInt();
		int y = 0;
		y = sc.nextInt();
		int z = 0;
		z = sc.nextInt();
		if (x == y && z == x) {
			System.out.println(10000 + x * 1000);
		} else if (x == y || x == z) {
			System.out.println(1000 + x * 100);
		} else if (y == z) {
			System.out.println(1000 + y * 100);
		} else {
			System.out.println(Math.max(Math.max(x, y), z) * 100);
		}
	}

}

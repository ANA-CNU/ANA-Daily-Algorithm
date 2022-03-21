import java.util.Scanner;

public class Q_14681 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = 1;
		int y = 1;
		x = sc.nextInt();
		y = sc.nextInt();
		if (x > 0 && y > 0) {
			System.out.println("1");
		} else if (x < 0 && y > 0) {
			System.out.println("2");
		} else if (x < 0 && y < 0) {
			System.out.println("3");
		} else {
			System.out.println("4");
		}
	}

}

import java.util.Scanner;

public class Q_2753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year = 0;
		year = sc.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

}

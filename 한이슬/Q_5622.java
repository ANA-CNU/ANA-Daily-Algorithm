import java.util.Scanner;

public class Q_5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String target = sc.next();
		int sum = 0;
		for (int i = 0; i < target.length(); i++) {
			char a = target.charAt(i);
			int turn = (int) a;
			if (turn >= 65 && turn <= 67) {
				sum += 3;
			} else if (turn >= 68 && turn <= 70) {
				sum += 4;
			} else if (turn >= 71 && turn <= 73) {
				sum += 5;
			} else if (turn >= 74 && turn <= 76) {
				sum += 6;
			} else if (turn >= 77 && turn <= 79) {
				sum += 7;
			} else if (turn >= 80 && turn <= 83) {
				sum += 8;
			} else if (turn >= 84 && turn <= 86) {
				sum += 9;
			} else if (turn >= 87 && turn <= 90) {
				sum += 10;
			}
		}
		System.out.println(sum);
	}

}

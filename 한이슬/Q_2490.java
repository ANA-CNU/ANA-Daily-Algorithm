import java.util.Scanner;

public class Q_2490 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		for (int j = 0; j < 3; j++) {
			int count = 0;
			for (int i = 0; i < 4; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < 4; i++) {
				if (arr[i] == 1) {
					count += 1;
				}
			}
			if (count == 1) {
				System.out.println("C");
			} else if (count == 2) {
				System.out.println("B");
			} else if (count == 3) {
				System.out.println("A");
			} else if (count == 4) {
				System.out.println("E");
			} else if (count == 0) {
				System.out.println("D");
			}
		}

	}
}

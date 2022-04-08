import java.util.Scanner;

public class Q_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		String score = sc.next();
		for(int i = 0; i<score.length(); i++) {
			sum = sum + (int) score.charAt(i)-48;
		}
		System.out.println(sum);
	}

}

import java.util.Scanner;

public class Q2525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int H = 0;
		int M = 0;
		int time = 0;
		int FT = 0;
		int FM = 0;
		H = sc.nextInt();
		M = sc.nextInt();
		time = sc.nextInt();
		FT = (H + ((M + time) / 60)) % 24;
		FM = (M + time) % 60;
		System.out.printf("%d %d", FT, FM);
	}

}

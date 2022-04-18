import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = sc.nextInt();
		int n = 2;

			while (result!=1){
				while (result % n != 0)
					++n;
				result = result / n;
				System.out.println(n);
			}
		}
}
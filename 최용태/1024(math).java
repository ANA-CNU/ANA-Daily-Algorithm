import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int x = sc.nextInt();
		int i = 0;
		int first = 0;
		
		for (int j = 0; j < x; j++)
			i += j;
		
			while (x <=100) {
				int cmp=(N - i) % x;
				System.out.println(cmp+" "+(N-i)/x);
				if (cmp==0 &&(N-i)/x>=0 ) {
					first = (N-i) / x;
					break;
				} else {
					i+=x;
					x++;
				}
			}

			if (x > 100)
				System.out.println("-1");
			else {
				for (int j = 0; j < x; j++) {
					System.out.print((first++)+" ");
				}
			}
	}
}
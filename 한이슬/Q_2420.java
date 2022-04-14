import java.util.*;
public class Q_2420 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong(), m=sc.nextLong();
		if (n>=m) {
			System.out.println(n-m);
		} else {System.out.println(m-n);}
	}

}

import java.util.Scanner;
import java.math.BigInteger;

public class Q_10757 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
		BigInteger sum = a.add(b);
		System.out.println(sum);
	}

}

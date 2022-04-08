import java.util.Scanner;

public class Q_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.replace("c=", "a");
		str = str.replace("c-", "b");
		str = str.replace("dz=", "c");
		str = str.replace("d-", "d");
		str = str.replace("lj", "e");
		str = str.replace("nj", "f");
		str = str.replace("s=", "g");
		str = str.replace("z=", "h");
		System.out.println(str.length());
	}

}

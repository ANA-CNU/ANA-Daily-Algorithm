import java.util.Scanner;

public class Q_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		for (int i = 97; i <= 122; i++) {
			char word = (char) i;
			System.out.print(s.indexOf(word)+" ");
		}
	}

}

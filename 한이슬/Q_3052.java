import java.util.Scanner;
import java.util.HashSet;

public class Q_3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i = 0; i<10; i++) {
			h.add(arr[i]%42);
		}
		System.out.println(h.size());
	}

}

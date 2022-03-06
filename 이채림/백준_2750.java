import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 백준_2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<>();
		
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			array.add(sc.nextInt());
		}

		Collections.sort(array);
		
		for(int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		sc.close();
	}
}

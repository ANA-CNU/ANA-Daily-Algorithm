import java.util.*;

public class Q_2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		int max = arr[0];
		int maxNum = 1;
		for (int i = 0; i < 9; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxNum = (i + 1);
			}
		}
		System.out.printf("%d"+"\n"+"%d",max,maxNum);
	}

}

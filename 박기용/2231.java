import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int[] intarr = new int[1000000];
        int min = 1000000;

        for (int i = 0; i < a; i++) {
            char[] arr = Integer.toString(i).toCharArray();
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum = sum + arr[j];
            }
            int b = i + (sum - arr.length * 48);

            if (b == a) {
                intarr[i] = i;
            }
        }

        for (int i = 0; i < 1000000; i++) {
            if (intarr[i] < min && intarr[i] != 0) {
                min = intarr[i];
            }
        }
        if (min != 1000000) {
            System.out.println(min);
        } else {
            System.out.println(0);
        }
    }
}

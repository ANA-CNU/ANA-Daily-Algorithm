import java.util.*;
public class Boj1654 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int K = in.nextInt();
        int N = in.nextInt();

        int[] arr = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = in.nextInt();
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {

            mid = (max + min) / 2;

            long count = 0;


            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }
            if(count < N) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}

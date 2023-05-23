import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int[] arr_sum = new int[(n*(n-1)*(n-2))/(3*2)];
        int q = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    arr_sum[q++] = arr[i] + arr[j] + arr[k];
                }
            }
        }

        int max = 0;
        for (int i=0; i<arr_sum.length; i++){
            if (arr_sum[i] <= m){
                if (arr_sum[i] > max) {
                    max = arr_sum[i];
                }
            }
        }
        System.out.println(max);
    }
}

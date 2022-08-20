import java.util.*;
import java.io.*;


public class Main {
    public static void search() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];
        int a[] = new int[N+1];

        if (N > 1) {
            for (int i = 1; i < N+1; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            dp[1] = a[1];
            dp[2] = a[1]+a[2];
            for (int i = 3; i < N+1; i++) {
                dp[i] += Math.max(dp[i - 2], dp[i - 3] + a[i - 1]) + a[i];
            }

            System.out.println(dp[N]);
        } else {
            System.out.println(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        search();
    }
}
package Dp;

import java.io.*;

public class backjoon_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num + 3];
        int[] dp = new int[num + 3];

        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1] + arr[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));
        for (int i = 4; i <= num; i++) {
            dp[i] = Math.max(Math.max(arr[i - 1] + dp[i - 3], arr[i - 1] + dp[i - 4]), Math.max(dp[i - 2], dp[i - 3])) + arr[i];
        }

        bw.write(Math.max(dp[num], dp[num - 1]) + "\n");
        bw.flush();
        bw.close();
    }
}

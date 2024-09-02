package Dp;

import java.io.*;
import java.util.*;

public class backjoon_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][4];// 빈칸 좌 우 총합
        Arrays.fill(dp[0], 1);
        dp[0][3] = 3;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][3] % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
            dp[i][3] = (dp[i][0] + dp[i][1] + dp[i][2]) % 9901;
        }

        bw.write(dp[n - 1][3] % 9901 + "\n");
        bw.flush();
        bw.close();
    }
}
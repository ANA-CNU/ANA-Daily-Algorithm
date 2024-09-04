package Dp;

import java.io.*;
import java.util.*;

public class backjoon_25633 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        int[] sum = new int[a];
        int[] dp = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (sum[j] >= arr[i]) { //dp가 바뀔 경우에만 바꿔줌
                    if (dp[j] > dp[i]) {
                        sum[i] = arr[i] + sum[j];
                        dp[i] = dp[j];
                    }
                }
            }
            if (dp[i] == 0) { //한번도 큰 값을 못 찾을 때
                sum[i] = arr[i];
            }
            dp[i]++;
        }

        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
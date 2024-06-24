package Dp;

import java.io.*;
import java.util.*;

public class backjoon_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] dprever = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);
        Arrays.fill(dprever, 1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dprever[i] = Math.max(dprever[i], dprever[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = dp[i] + dprever[i];
            if (ans[i] > max) max = ans[i];
        }

        bw.write(max - 1 + "\n");
        bw.flush();
        bw.close();

    }
}

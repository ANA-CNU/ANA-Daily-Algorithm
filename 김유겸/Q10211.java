package _2022_1학기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Q10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dp = new int[t];

        for (int i = 0; i < t; i++) {
            dp[i] = Integer.MIN_VALUE;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = j; k < n; k++) {
                    sum += arr[k];
                    if (sum > dp[i]) {
                        dp[i] = sum;
                    }
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(dp[i]);
        }
    }
}

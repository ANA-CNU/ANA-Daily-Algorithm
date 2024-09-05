package Dp;

import java.io.*;
import java.util.*;

public class backjoon_25634 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        int[] light = new int[a];
        int[] dp = new int[a];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < light.length; i++) {
            light[i] = Integer.parseInt(st.nextToken());
            if (light[i] == 1) sum += arr[i];
        }

        //dp 누적합
        if (light[0] == 1) dp[0] = sum - arr[0];
        else dp[0] = sum + arr[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (light[i] == 0) dp[i] = Math.max(sum + arr[i], dp[i - 1] + arr[i]); //하나 올릴건지 아니면 전부터 이어나갈건지
            else dp[i] = Math.max(sum - arr[i], dp[i - 1] - arr[i]); //하나만 뺄건지 아니면 이어나갈건지
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
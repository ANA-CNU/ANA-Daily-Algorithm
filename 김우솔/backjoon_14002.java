package Dp;

import java.io.*;
import java.util.*;

public class backjoon_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[num];
        int[] arr = new int[num];

        /**
         * lcs처럼 역추적하는 문제였다
         */

        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                index = i;
            }
        }

        bw.write(max + "\n");
        List<Integer> list = new ArrayList<>();
        for (int i = index; i >= 0; i--) {
            if (max == dp[i]) {
                list.add(arr[i]);
                max--;
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }
}
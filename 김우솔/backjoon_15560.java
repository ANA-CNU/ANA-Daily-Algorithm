package Dp;

import java.io.*;
import java.util.*;

public class backjoon_15560 {
    static int u;
    static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        /**
         * 최대부분배열의 연습문제
         * u와 v는 고정이고 필요로하는건 구간과 구간길이의 상수곱의 최대값
         * 그 최대값의 구간도 같을경우 긴게 좋다... 구간도 구해야함
         * 45번줄에 len + 1이 아니라서 틀린건가???? 아놔...
         */

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 0) {
                int lo = Integer.parseInt(st.nextToken());
                int hi = Integer.parseInt(st.nextToken());
                int len = 0;
                int max = re(arr[lo], 0);

                dp[lo] = arr[lo];
                for (int j = lo + 1; j <= hi; j++) {
                    int now = re(arr[j], 0);
                    if (now > re(dp[j - 1] + arr[j], len + 1)) {//현재부터 다시 시작하는 경우
                        //arr[j] > dp[j - 1] + arr[j]
                        len = 0;
                        dp[j] = arr[j];
                    }else {//이어나가는 경우 + 최대값이 같을경우 이어나간다 // 같을 경우 무조건 이어나가나?
                        len++;
                        dp[j] = dp[j - 1] + arr[j];
                    }
                    max = Math.max(max, re(dp[j], len));
                }
                // 출력
                bw.write(max + "\n");
            }else {
                int index = Integer.parseInt(st.nextToken());
                arr[index] = Integer.parseInt(st.nextToken());
            }
        }

        bw.flush();
        bw.close();
    }
    static int re(int sum, int len) {
        return u * sum + v * len;
    }
}

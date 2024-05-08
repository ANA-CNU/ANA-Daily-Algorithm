package Dijkstra;

import java.io.*;
import java.util.*;

public class backjoon_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        HideandSeek2 HaS = new HideandSeek2(start, end);

        HaS.StartHaS();
        bw.write(HaS.getmin() + "\n");
        bw.flush();
        bw.close();
    }
}

class HideandSeek2 {
    private int[] dp;
    private boolean[] visited;
    private int start;
    private int end;
    HideandSeek2(int st, int en) {
        start = st;
        end = en;
        dp = new int[100001];
        visited = new boolean[100001];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[st] = 0;
    }
    void StartHaS() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{start, 0});
        visited[start] = true;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[0] == end) break;
            if (temp[0] * 2 < dp.length && !visited[temp[0] * 2]) {
                if (dp[temp[0] * 2] > dp[temp[0]] * 2) {
                    dp[temp[0] * 2] = dp[temp[0]];
                    visited[temp[0] * 2] = true;
                    pq.add(new int[]{temp[0] * 2, dp[temp[0] * 2]});
                }
            }
            if (temp[0] + 1 < dp.length && !visited[temp[0] + 1]) {
                if (dp[temp[0] + 1] > dp[temp[0]] + 1) {
                    dp[temp[0] + 1] = dp[temp[0]] + 1;
                    visited[temp[0] + 1] = true;
                    pq.add(new int[]{temp[0] + 1, dp[temp[0] + 1]});
                }
            }
            if (temp[0] - 1 >= 0 && !visited[temp[0] - 1]) {
                if (dp[temp[0] - 1] > dp[temp[0]] - 1) {
                    dp[temp[0] - 1] = dp[temp[0]] + 1;
                    visited[temp[0] - 1] = true;
                    pq.add(new int[]{temp[0] - 1, dp[temp[0] - 1]});
                }
            }
        }
    }
    int getmin() {
        return dp[end];
    }
}
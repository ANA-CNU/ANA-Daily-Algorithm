package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15664 {
    static int n, m;
    static int[] map;
    static int[] result;
    static boolean[] visit;

    static void backtracking(int start, int cnt, StringBuilder sb) {

        if (cnt == m) {
            for (int i=0; i<m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");

        } else {
            int num = 0;
            for (int i=start; i<n; i++) {
                if (!visit[i]) {
                    if (num == map[i]) continue;

                    visit[i] = true;
                    result[cnt] = map[i];
                    backtracking(i+1, cnt+1, sb);
                    visit[i] = false;

                    num = map[i];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n];
        result = new int[m];
        visit = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);
        StringBuilder sb = new StringBuilder();
        backtracking(0, 0, sb);
        System.out.print(sb);

    }
}
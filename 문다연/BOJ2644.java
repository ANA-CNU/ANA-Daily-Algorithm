package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import annotation.*;
@BOJ(   number = 2644,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 16))
public class BOJ2644 {
    static int N;
    static boolean[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        graph = new boolean[N][N];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            graph[s][e] = graph[e][s] = true;
        }
        System.out.println(BFS(start, end));
    }

    private static int BFS(int start, int end) {
        boolean[] visit = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);

        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int now = q.poll();
                if (now == end)
                    return ans;
                for (int i = 0; i < N; i++) {
                    if (graph[now][i] && !visit[i]) {
                        visit[i] = true;
                        q.add(i);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}

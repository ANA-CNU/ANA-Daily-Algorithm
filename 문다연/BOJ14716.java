package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import annotation.*;
@BOJ(   number = 14716,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 8))
public class BOJ14716 {

    static int M, N;
    static int [][] banner;
    static boolean [][] visited;
    static int [] moveRow = {-1, 1, 0, 0, -1, 1, -1, 1}, moveCol = {0, 0, -1, 1, -1, -1, 1, 1};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < moveRow.length; i++) {
                int nr = r + moveRow[i];
                int nc = c + moveCol[i];
                if (nr < 0 || nc < 0 || nr >= M || nc >= N || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if (banner[nr][nc] == 1) queue.add(new int[] {nr, nc});
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        banner = new int[M][N];
        visited = new boolean[M][N];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) banner[m][n] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (banner[m][n] == 1) {
                    if (!visited[m][n]) {
                        dfs(m, n);
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import annotation.*;
@BOJ(   number = 15240,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 10))

public class BOJ15240 {
    static int R, C, X, Y, K, target;
    static int [][] matrix;
    static int [] moveRow = {-1, 1, 0, 0}, moveCol = {0, 0, -1, 1};

    static void dfs() {
        boolean [][] visited = new boolean[R][C];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {X, Y});
        visited[X][Y] = true;
        matrix[X][Y] = K;

        while(!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveRow[i];
                int ny = y + moveCol[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (target == matrix[nx][ny]) {
                    matrix[nx][ny] = K;
                    queue.add(new int[] {nx, ny});
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        matrix = new int[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                matrix[r][c] = line.charAt(c) - '0';
            }
        }
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        target = matrix[X][Y];
        dfs();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(matrix[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

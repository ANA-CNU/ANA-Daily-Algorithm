package BOJ;

import java.io.*;
import java.util.*;
import annotation.*;
@BOJ(   number = 24819,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 18))
public class BOJ24819 {

    static int t, N, M;
    static char [][] grid;
    static int [][] count;
    static int [] moveRow = {-1, 1, 0, 0}, moveCol = {0, 0, -1, 1};
    static final char START = 'S', UP = 'U', DOWN = 'D', LEFT = 'L', RIGHT = 'R', BURN = '1', PATH = '0';

    static int BFS(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        boolean [][] visited = new boolean[N][M];
        visited[x][y] = true;
        queue.add(new int[] {x, y});
        while(!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = row + moveRow[i];
                int ny = col + moveCol[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) return count[row][col];
                if (visited[nx][ny] || grid[nx][ny] == '1' || count[row][col] == t) continue;

                if (grid[nx][ny] == UP && i != 1) continue;
                else if (grid[nx][ny] == DOWN && i != 0) continue;
                else if (grid[nx][ny] == LEFT && i != 3) continue;
                else if (grid[nx][ny] == RIGHT && i != 2) continue;

                visited[nx][ny] = true;
                count[nx][ny] = count[row][col] + 1;
                queue.add(new int[] {nx, ny});
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken()); // 남은 탈출 시간
        N = Integer.parseInt(st.nextToken()); // 그리드 세로
        M = Integer.parseInt(st.nextToken()); // 그리드 가로

        grid = new char[N][M];
        count = new int[N][M];
        int x = 0, y = 0;
        for (int n = 0; n < N; n++) {
            String line = br.readLine();
            for (int m = 0; m < M; m++) {
                grid[n][m] =  line.charAt(m);
                if (grid[n][m] == START) {
                    x = n; y = m;
                }
            }
        }
        int ret = BFS(x, y);
        if (ret == -1) System.out.println("NOT POSSIBLE");
        else System.out.println(ret);
    }
}

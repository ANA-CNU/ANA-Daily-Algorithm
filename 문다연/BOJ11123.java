package BOJ;

import java.io.*;
import java.util.*;
import annotation.*;
@BOJ(   number = 11123,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 9))
public class BOJ11123 {

    static int T, H, W;
    static char [][] map;
    static boolean [][] visited;
    static final char SHEEP = '#', GRASS = '.';
    static int [] moveRow = {-1, 1, 0, 0}, moveCol = {0, 0, -1, 1};

    static void dfs(int h, int w) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {h, w});

        while(!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveRow[i];
                int ny = y + moveCol[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny]) continue;
                if (map[nx][ny] == SHEEP) queue.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for (int h = 0; h < H; h++) {
                String line = br.readLine();
                for (int w = 0; w < W; w++) {
                    map[h][w] = line.charAt(w);
                }
            }

            visited = new boolean[H][W];
            int cnt = 0;
            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    if (!visited[h][w] && map[h][w] == SHEEP) {
                        dfs(h, w);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}

package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int x;
    int y;
    int count;

    Location(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Q2178 {
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static Queue<Location> Q;
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        Q = new LinkedList();
        Q.offer(new Location(1, 1, 1));
        BFS();
        System.out.println(answer);
    }

    static void BFS() {
        while (!Q.isEmpty()) {

            Location l = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = l.x + dx[i];
                int ny = l.y + dy[i];

                if(nx == N && ny == M){
                    answer = Math.min(l.count + 1, answer);
                }
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    Q.offer(new Location(nx, ny, l.count + 1));
                }
            }
        }
    }
}

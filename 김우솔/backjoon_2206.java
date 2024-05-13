package BFS;

import java.io.*;
import java.util.*;

public class backjoon_2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        BreakWall breakWall = new BreakWall(a, b);
        for (int i = 1; i <= a; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= b; j++) {
                breakWall.addNode(i, j, temp.charAt(j - 1));
            }
        }

        bw.write(breakWall.StratBFS() + "\n");
        bw.flush();
        bw.close();
    }
}

class BreakWall {
    private int[][][] adj;
    /**
     * [][][0] a
     * [][][1] b
     * [][][2] 에너지
     * [][][3] 이동 count
     */
    private int[][] map; //지도
    private int[] end;
    private int[] updown = {1, 0, -1, 0};
    private int[] leftright = {0, 1, 0, -1};

    BreakWall(int a, int b) {
        adj = new int[a + 1][b + 1][4];
        map = new int[a + 1][b + 1];
        end = new int[]{a, b};
        for (int i = 0; i <= a; i++) {
            map[i][0] = 2;
        }
        for (int i = 0; i <= b; i++) {
            map[0][i] = 2;
        }
        adj[a][b][3] = -1;
        adj[1][1][3] = adj[1][1][2] = 1;
    }

    void addNode(int a, int b, char c) {
        adj[a][b][0] = a;
        adj[a][b][1] = b;
        if (c == '1') {
            map[a][b] = 2;
            adj[a][b][2] = 1;
        }
    }

    int StratBFS() {
        Queue<int[]> queue = new LinkedList<>();
        map[1][1] = 3;
        queue.add(adj[1][1]);

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[0] == end[0] && temp[1] == end[1]) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ud = updown[i] + temp[0];
                int lr = leftright[i] + temp[1];

                if (ud <= 0 || ud >= adj.length || lr <= 0 || lr >= adj[0].length) continue;

                if (adj[temp[0]][temp[1]][2] == 0) { //에너지를 사용했음
                    if (adj[temp[0]][temp[1]][2] - map[ud][lr] < 0) continue;
                    map[ud][lr] = 1;
                    adj[ud][lr][3] = adj[temp[0]][temp[1]][3] + 1;
                    queue.add(adj[ud][lr]);
                } else if (adj[temp[0]][temp[1]][2] == 1) { //지금 에너지가 1 최고권한
                    if (map[ud][lr] == 0) {//방문하지 않은 벽이 아닌 곳이라면
                        adj[ud][lr][2] = 1;
                        map[ud][lr] = 3;
                        adj[ud][lr][3] = adj[temp[0]][temp[1]][3] + 1;
                        queue.add(adj[ud][lr]);
                    } else if (map[ud][lr] == 1) {//방문한 벽이 아닌 곳
                        adj[ud][lr][2] = 1;
                        map[ud][lr] = 3;
                        adj[ud][lr][3] = adj[temp[0]][temp[1]][3] + 1;
                        queue.add(adj[ud][lr]);
                    } else if (map[ud][lr] == 2) {//벽이면
                        adj[ud][lr][2] = 0;
                        adj[ud][lr][3] = adj[temp[0]][temp[1]][3] + 1;
                        queue.add(adj[ud][lr]);
                    }
                }
            }
        }
        return adj[end[0]][end[1]][3];
    }
}
package BFS;

import java.io.*;
import java.util.*;

public class backjoon_17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        MovingPipe mp = new MovingPipe(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mp.addNode(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        mp.StartBFS();
        bw.write(mp.getCount() + "\n");
        bw.flush();
        bw.close();
    }
}

class MovingPipe {
    private int V;
    private int[][][] adj; //좌표, 현상태
    private boolean[][] map; //거리
    private int count = 0;

    /**
     * 가로면 1
     * 세로면 2
     * 대각선은 3
     */

    MovingPipe(int a) {
        V = a;
        adj = new int[a][a][3];
        map = new boolean[a][a];
    }
    void addNode(int a, int b, int c) {
        adj[a][b][0] = a;
        adj[a][b][1] = b;
        if (c == 1) map[a][b] = true;
    }
    void StartBFS() {
        if (map[V - 1][V - 1]) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1, 1});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == V - 1 && temp[1] == V - 1) {
                count++;
                continue;
            }

            int y = temp[0];
            int x = temp[1];
            switch (temp[2]) {
                case 1:
                    if (x + 1 >= V) break;
                    if (map[y][x + 1]) break;
                    q.add(new int[]{y, x + 1, 1});
                    if (y + 1 < V && !map[y + 1][x] && !map[y + 1][x + 1]) {
                        q.add(new int[]{y + 1, x + 1, 3});
                    }
                    break;
                case 2:
                    if (y + 1 >= V) break;
                    if (map[y + 1][x]) break;
                    q.add(new int[]{y + 1, x, 2});
                    if (x + 1 < V && !map[y][x + 1] && !map[y + 1][x + 1]) {
                        q.add(new int[]{y + 1, x + 1, 3});
                    }
                    break;
                case 3:
                    if (y + 1 < V && !map[y + 1][x]) {
                        q.add(new int[]{y + 1, x, 2});
                    }
                    if (x + 1 < V && !map[y][x + 1]) {
                        q.add(new int[]{y, x + 1, 1});
                    }
                    if (y + 1 >= V || x + 1 >= V) break;
                    if (map[y + 1][x] || map[y][x + 1] || map[y + 1][x + 1]) break;
                    q.add(new int[]{y + 1, x + 1, 3});
                    break;
            }
        }
    }
    int getCount() {
        return count;
    }
}
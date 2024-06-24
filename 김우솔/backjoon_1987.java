package DFS;

import java.io.*;
import java.util.*;

public class backjoon_1987 {
    /**
     * 분류는 DFS로 했지만 백트래킹을 응용한 문제같다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Alphbet ab = new Alphbet(r,c);

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                ab.addNode(i, j, temp.charAt(j));
            }
        }

        ab.startFind(0, 0, 0);
        bw.write(ab.getMax() + "\n");
        bw.flush();
        bw.close();
    }
}

class Alphbet {
    private int[][][] adj;
    private char[][] map;
    private boolean[] vis;
    private int[] updown = {1, 0, -1, 0};
    private int[] leftright = {0, 1, 0, -1};
    private int max = 1;
    Alphbet(int r, int c) {
        adj = new int[r][c][2];
        map = new char[r][c];
        vis = new boolean[26];
    }
    void addNode(int a, int b, char c) {
        adj[a][b][0] = a;
        adj[a][b][1] = b;
        map[a][b] = c;
    }

    void startFind(int r, int c, int depth) {
        if (vis[map[r][c] - 'A']) {
            if (max < depth) max = depth;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ud = r + updown[i];
            int lr = c + leftright[i];
            if (ud < 0 || ud >= map.length || lr < 0 || lr >= map[0].length) continue;
            vis[map[r][c] - 'A'] = true;
            startFind(ud, lr, depth + 1);
            vis[map[r][c] - 'A'] = false;
        }
    }

    public int getMax() {
        return max;
    }
}


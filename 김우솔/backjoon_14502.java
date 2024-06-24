package BackTracking;

import java.io.*;
import java.util.*;

public class backjoon_14502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 백트래킹 + BFS문제이다
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Lab lab = new Lab(r, c);

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                lab.addroad(i,j,Integer.parseInt(st.nextToken()));
            }
        }

        lab.startLabDFS(0);
        bw.write(lab.getMax() + "\n");
        bw.flush();
        bw.close();

    }
}

class Lab {
    private int[][] dis;
    private boolean[][] vis;
    private int[][][] adj;
    private ArrayList<int[]> start;
    private int max = 0;
    private int[] updown = {1, 0, -1, 0};
    private int[] rightleft = {0, 1, 0, -1};

    Lab(int a, int b) {
        start = new ArrayList<>();
        dis = new int[a][b];
        vis = new boolean[a][b];
        adj = new int[a][b][2];
    }
    void addroad(int a, int b, int c) {
        dis[a][b] = c;
        adj[a][b][0] = a;
        adj[a][b][1] = b;
        if (c == 2) {
            start.add(adj[a][b]);
            vis[a][b] = true;
        }else if (c == 1) {
            vis[a][b] = true;
        }
    }
    void startLabDFS(int depth) {
        if (depth == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (dis[i][j] == 0) {
                    vis[i][j] = true;
                    dis[i][j] = 1;
                    startLabDFS(depth + 1);
                    dis[i][j] = 0;
                    vis[i][j] = false;
                }
            }
        }
    }
    void BFS() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visnew = new boolean[vis.length][vis[0].length];
        for (int i = 0; i < vis.length; i++) {
            visnew[i] = vis[i].clone();
        }
        for (int i = 0; i < start.size(); i++) {
            int[] temp = start.get(i);
            q.add(temp);
        }
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int ud = updown[i] + temp[0];
                int lf = rightleft[i] + temp[1];
                if (ud < 0 || ud >= vis.length || lf < 0 || lf >= vis[0].length) continue;;
                if (visnew[ud][lf]) continue;
                q.add(adj[ud][lf]);
                visnew[ud][lf] = true;
            }
        }
        countzero(visnew);
    }
    void countzero(boolean[][] visnew) {
        int count = 0;
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (!visnew[i][j]) count++;
            }
        }
        if (count > max) max = count;
    }

    public int getMax() {
        return max;
    }
}

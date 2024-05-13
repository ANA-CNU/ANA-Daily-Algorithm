package BFS;

import java.io.*;
import java.util.*;

public class backjoon_1167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeDiameter2 td2 = new TreeDiameter2(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int dis = Integer.parseInt(st.nextToken());
                td2.addNode(start, end, dis);
            }
        }

        td2.StartBFS(1);
        td2.StartBFS(td2.getGetindex());
        bw.write(td2.getMax() + "\n");
        bw.flush();
        bw.close();
    }
}

class TreeDiameter2 {
    private int[] dis;
    private ArrayList[] adj;
    private boolean[] vis;
    private int max = 0;
    private int getindex = 0;
    TreeDiameter2(int n) {
        dis = new int[n + 1];
        vis = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 0; i < vis.length; i++) {
            adj[i] = new ArrayList();
        }
    }
    void addNode(int a, int b, int c) {
        adj[a].add(new int[]{b, c});
        adj[b].add(new int[]{a, c});
    }
    void StartBFS(int st) {
        Arrays.fill(vis, false);
        Arrays.fill(dis, 0);
        Queue<int[]> queue = new LinkedList<>();
        vis[st] = true;
        queue.add(new int[]{st, 0});//도착지, 가중치

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (dis[temp[0]] > max) {
                max = dis[temp[0]];
                getindex = temp[0];
            }
            Iterator<int[]> it = adj[temp[0]].iterator();

            while (it.hasNext()) {
                int[] a = it.next();
                if (!vis[a[0]]) {
                    queue.add(a);
                    vis[a[0]] = true;
                    dis[a[0]] = dis[temp[0]] + a[1];
                }
            }
        }
    }
    int getMax() {
        return max;
    }

    public int getGetindex() {
        return getindex;
    }
}
package Dijkstra;

import java.io.*;
import java.util.*;

public class backjoon_1504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        SpecialRoad sr = new SpecialRoad(N);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            sr.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int vis1 = Integer.parseInt(st.nextToken());
        int vis2 = Integer.parseInt(st.nextToken());

        int temp1 = sr.startFind(1, vis1, 0);
        int temp2 = sr.startFind(1, vis2, 0);
        if (temp1 == -1  || temp2 == -1) {
            System.out.println(-1);
            System.exit(0);
        }
        int to1to2 = sr.startFind(vis1, vis2, temp1);
        int to2to1 = sr.startFind(vis2, vis1, temp2);

        int end1 = sr.startFind(vis2, N, to1to2);
        int end2 = sr.startFind(vis1, N, to2to1);

        bw.write(Math.min(end2, end1) + "\n");
        bw.flush();
        bw.close();
    }
}

class SpecialRoad {
    private ArrayList[] adj;
    private int[] dis;
    SpecialRoad(int a) {
        dis = new int[a + 1];
        adj = new ArrayList[a + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
    }
    void addNode(int a, int b, int c) {
        adj[a].add(new int[]{b, c});
        adj[b].add(new int[]{a, c});
    }

    int startFind(int start, int end, int value) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = value;
        pq.add(new int[]{start, value});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[0] == end) return temp[1];
            if (temp[1] > dis[temp[0]]) continue;

            Iterator<int[]> it = adj[temp[0]].iterator();
            while (it.hasNext()) {
                int[] a = it.next();
                if (dis[a[0]] <= dis[temp[0]] + a[1]) continue;
                dis[a[0]] = dis[temp[0]] + a[1];
                pq.add(new int[]{a[0], dis[a[0]]});
            }
        }

        return -1;
    }
}


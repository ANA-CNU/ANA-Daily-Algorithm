package Dijkstra;

import java.io.*;
import java.util.*;

public class backjoon_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ShortRoad sr = new ShortRoad(V, E);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            sr.addRoad(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        sr.StartFindShort(start);

        bw.write(sr.getanswer());
        bw.flush();
        bw.close();
    }
}

class ShortRoad {
    private int[] dis;
    private LinkedList[] adj;
    ShortRoad(int a, int b) {
        dis = new int[a + 1];
        adj = new LinkedList[a + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    void addRoad(int a, int b, int c) {
        adj[a].add(new int[]{b, c});
    }
    void StartFindShort(int start) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[1] > dis[temp[0]]) continue;

            Iterator<int[]> it = adj[temp[0]].iterator();
            while (it.hasNext()) {
                int[] a = it.next();
                if (dis[a[0]] <= dis[temp[0]] + a[1]) continue;
                dis[a[0]] = dis[temp[0]] + a[1];
                pq.add(new int[]{a[0], dis[a[0]]});
            }
        }
    }
    String getanswer() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dis[i]).append("\n");
        }
        return sb.toString();
    }
}
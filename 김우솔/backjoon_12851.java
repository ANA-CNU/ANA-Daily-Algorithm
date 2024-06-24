package Dijkstra;

import java.io.*;
import java.util.*;

public class backjoon_12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        HideandSeek3 hs = new HideandSeek3(start, end);
        hs.StartHaS3();

        bw.write(hs.getDis() + "\n" + hs.getCount() + "\n");
        bw.flush();
        bw.close();

    }
}

class HideandSeek3 {
    private int[] dis;
    private int count = 0;
    private ArrayList[] adj;
    private int start;
    private int end;

    HideandSeek3(int a, int b) {
        start = a;
        end = b;
        dis = new int[Math.max(a,b) + 10];
        adj = new ArrayList[Math.max(a,b) + 10];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
    }

    void StartHaS3() {
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
            //if (dis[end] < temp[1]) break;
            if (temp[0] == end) {
                if (temp[1] == dis[temp[0]]) {
                    count++;
                    continue;
                }
            }

            if (temp[0] + 1 < dis.length) {
                if (dis[temp[0] + 1] >= dis[temp[0]] + 1) {
                    dis[temp[0] + 1] = dis[temp[0]] + 1;
                    pq.add(new int[] {temp[0] + 1, dis[temp[0] + 1]});
                }
            }

            if (temp[0] - 1 >= 0) {
                if (dis[temp[0] - 1] >= dis[temp[0]] + 1) {
                    dis[temp[0] - 1] = dis[temp[0]] + 1;
                    pq.add(new int[] {temp[0] - 1, dis[temp[0] - 1]});
                }
            }

            if (temp[0] * 2 < dis.length) {
                if (dis[temp[0] * 2] >= dis[temp[0]] + 1) {
                    dis[temp[0] * 2] = dis[temp[0]] + 1;
                    pq.add(new int[] {temp[0] * 2, dis[temp[0] * 2]});
                }
            }

        }

    }

    public int getDis() {
        return dis[end];
    }

    public int getCount() {
        return count;
    }
}
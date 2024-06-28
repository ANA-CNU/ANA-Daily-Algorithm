package Dijkstra;

import java.io.*;
import java.util.*;

public class backjoon_11779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ShortRoad22 sr2 = new ShortRoad22(n, m);
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            sr2.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        sr2.setStEnd(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        sr2.StartFindShortRoad2();
    }
}

class ShortRoad22 {
    StringBuffer sb = new StringBuffer();
    private int[] dis;
    private int[] ans;
    private ArrayList[] adj;
    private int start, end;

    ShortRoad22(int n, int m) {
        adj = new ArrayList[n + 1];
        dis = new int[n + 1];
        ans = new int[n + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
    }

    void setStEnd(int st, int en) {
        start = st;
        end = en;
    }

    void addNode(int a, int b, int c) {
        adj[a].add(new int[]{b, c});
    }

    void StartFindShortRoad2() {
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{start, 0});
        dis[start] = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();

            if (temp[0] == end) {
                sb.append(temp[1]).append("\n");

                //여기에 경로 개수랑 경로 sb에 출력
                printRoad();
                System.out.println(sb);
                break;
            }
            if (temp[1] > dis[temp[0]]) continue;

            Iterator<int[]> it = adj[temp[0]].iterator();
            while (it.hasNext()) {
                int[] a = it.next();
                if (dis[a[0]] <= dis[temp[0]] + a[1]) continue;
                dis[a[0]] = dis[temp[0]] + a[1];
                pq.add(new int[]{a[0], dis[a[0]]});
                ans[a[0]] = temp[0];
            }
        }
    }

    void printRoad() {
        int temp = end;
        StringBuffer road = new StringBuffer();
        ArrayList list = new ArrayList();
        while (true) {
            if (temp == start) {
                list.add(temp);
                break;
            }
            list.add(temp);
            temp = ans[temp];
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            road.append(list.get(i)).append(" ");
        }
        sb.append(list.size()).append("\n");
        sb.append(road);
    }
}

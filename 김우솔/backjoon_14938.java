package notyet;

import java.io.*;
import java.util.*;

public class backjoon_14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        SogangGroundDijkstra sgD = new SogangGroundDijkstra(N, M);
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            sgD.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < arr.length; i++) {
            sgD.Startdijkstra(i, arr);
        }

        bw.write(sgD.itemvalue() + "\n");
        bw.flush();
        bw.close();
    }
}

class SogangGroundDijkstra {
    private ArrayList[] adj;
    private int[] dis;
    private int[] ans;
    private int area;
    SogangGroundDijkstra(int N, int M) {
        area = M;
        dis = new int[N + 1];
        ans = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
    }
    void addNode(int a, int b, int c){
        adj[a].add(new int[]{b, c});
        adj[b].add(new int[]{a, c});
    }

    void Startdijkstra(int i, int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[i] = 0;
        pq.add(new int[]{i, 0});

        while (!pq.isEmpty()) {
            int temp[] = pq.poll();

            if (dis[temp[0]] < temp[1]) continue;

            Iterator<int[]> it = adj[temp[0]].iterator();
            while (it.hasNext()) {
                int[] a = it.next();

                if (dis[a[0]] <= dis[temp[0]] + a[1]) continue;
                dis[a[0]] = dis[temp[0]] + a[1];
                pq.add(new int[]{a[0], dis[a[0]]});
            }
        }

        int count = 0;
        for (int j = 1; j < dis.length; j++) {
            if (dis[j] <= area) count += arr[j];
        }
        ans[i] = count;
    }

    int itemvalue() {
        int max = 0;
        for (int i = 1; i < ans.length; i++) {
            if (max < ans[i]) max = ans[i];
        }
        return max;
    }
}
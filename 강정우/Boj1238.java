import java.io.*;
import java.util.*;

public class Boj1238 {
    static class Node implements Comparable<Node> {
        int x;
        int weight;
        public Node(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int n, m, x;
    static int[][] load;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        load = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            load[x][y] = z;
        }
        int maxTime = 0;
        int[] distToX = dijkstra(x);
        for (int i = 1; i <= n; i++) {
            int[] distFromI = dijkstra(i);
            maxTime = Math.max(maxTime, distToX[i] + distFromI[x]);
        }
        System.out.println(maxTime);
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int x = poll.x;
            if (visited[x]) continue;
            visited[x] = true;
            for (int i = 1; i <= n; i++) {
                if (load[x][i] > 0 && result[i] > result[x] + load[x][i]) {
                    result[i] = result[x] + load[x][i];
                    pq.offer(new Node(i, result[i]));
                }
            }
        }
        return result;
    }
}

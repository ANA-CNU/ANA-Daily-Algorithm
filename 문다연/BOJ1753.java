package BOJ;

import java.util.*;
import java.io.*;
import annotation.*;
@BOJ(   number = 1753,
        tier = BaekjoonTier.GOLD_V,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 1))
public class BOJ1753 {
    static class Edge implements Comparable<Edge> {
        int vertex, weight;
        Edge (int v, int w) {
            this.vertex = v;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int [] cost;
    static boolean [] visited;
    static LinkedList<Edge> [] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;
        graph = new LinkedList[V];
        visited = new boolean[V];
        for (int v = 0; v < V; v++) graph[v] = new LinkedList<>();

        for (int e = 0; e < E; e++) { // u -> v, 가중치 w
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u - 1].add(new Edge(v - 1, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        cost = new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        pq.add(new Edge(start, cost[start]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.vertex]) continue;

            Iterator it = graph[cur.vertex].iterator();
            while (it.hasNext()) {
                Edge next = (Edge) it.next();
                int newWeight = cur.weight + next.weight;
                if (!visited[next.vertex] && cost[next.vertex] > newWeight) {
                    cost[next.vertex] = newWeight;
                    pq.add(new Edge(next.vertex, cost[next.vertex]));
                }
            }
            visited[cur.vertex] = true;
        }
        for (int getCost : cost) {
            sb.append(getCost == Integer.MAX_VALUE ? "INF" : getCost).append("\n");
        }
        System.out.println(sb);
    }
}

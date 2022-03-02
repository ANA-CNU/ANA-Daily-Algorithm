package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import annotation.*;
@BOJ(   number = 1916,
        tier = BaekjoonTier.GOLD_V,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 3))

public class BOJ1916 {

    static class Bus implements Comparable<Bus> {
        int to, weight;
        Bus (int to, int weight) {
            this.to = to; this.weight = weight;
        }

        @Override
        public int compareTo(Bus o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        LinkedList[] city = new LinkedList[N + 1];
        for (int n = 0; n <= N; n++) {
            city[n] = new LinkedList<Bus>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            city[city1].add(new Bus(city2, weight));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int [] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[from] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(from, cost[from]));
        boolean [] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            Bus cur = pq.poll();
            if (visited[cur.to]) continue;

            Iterator it = city[cur.to].iterator();
            while (it.hasNext()) {
                Bus next = (Bus) it.next();
                int newCost = cur.weight + next.weight;
                if (!visited[next.to] && cost[next.to] > newCost) {
                    cost[next.to] = newCost;
                    pq.add(new Bus(next.to, newCost));
                }
            }
            visited[cur.to] = true;
        }
        System.out.println(cost[to]);
    }
}

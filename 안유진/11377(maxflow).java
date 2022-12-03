import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int N,M,K;
    final static int dest = 2499;
    static int capacity[][];
    static int flow[][];
    static ArrayList<Integer> list[];

    static int totalflow = 0;

    static boolean flag;
    static int parent[] = new int[2500];
    public static void maxflow(int start) {
        flag = false;

        Queue<Integer> queue = new LinkedList<>();
        while (true) {
            queue.clear();
            Arrays.fill(parent, -1);

            parent[start] = start;
            queue.add(start);

            while (!queue.isEmpty() && parent[dest] == -1){
                int current = queue.remove();
                for(int next : list[current]) {
                    if(capacity[current][next] - flow[current][next] > 0 && parent[next] == -1) {
                        queue.add(next);
                        parent[next] = current;
                    }
                }
            }

            if(parent[dest] == -1) {
                return;
            }

            for(int i = dest; i != start; i = parent[i]) {
                flow[parent[i]][i] += 1;
                flow[i][parent[i]] -= 1;
            }

            flag = true;
            totalflow++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        capacity = new int[2500][2500];
        flow = new int[2500][2500];
        list = new ArrayList[2500];

        for(int i = 0; i < 2500; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            capacity[0][i] = 1;
            list[0].add(i);

            for(int j = 0; j < num; j++) {
                int temp = Integer.parseInt(st.nextToken());
                capacity[i][temp + 1000] = 1;

                list[i].add(temp + 1000);
                list[temp + 1000].add(i);
            }
        } //input end

        for(int i = 1; i < M + 1; i++){
            list[i + 1000].add(dest);
            capacity[i + 1000][dest] = 1;
        }

        maxflow(0);
        int currentTotal = totalflow;
        totalflow = 0;

        for(int i = 1; i < N + 1; i++) {
            capacity[0][i]++;
        }

        maxflow(0);

        System.out.println(currentTotal + Math.min(K, totalflow));
    }
}

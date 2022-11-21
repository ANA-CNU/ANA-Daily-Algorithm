import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int capacity[][];
    static int flow[][];
    static int totalFlow = 0;
    static Queue<Integer> queue;
    public static void maxFlow(int source, int dest){
        int parent[] = new int[N + 1];

        while (true) {
            Arrays.fill(parent, -1);
            queue = new LinkedList<>();

            parent[source] = source;
            queue.add(source);

            while (!queue.isEmpty() && parent[dest] == -1) {
                int current = queue.remove();
                for(int next = 0; next < N + 1; next++){
                    if(capacity[current][next] - flow[current][next] > 0 && parent[next] == -1) {
                        queue.add(next);
                        parent[next] = current;
                    }
                }
            }
            if(parent[dest] == -1){ //만약 마지막 도착지까지 더이상 갱신이없으면 끝
                break;
            }

            int min = Integer.MAX_VALUE;

            for(int i = dest; i != source; i = parent[i]){ //시작지점부터 끝지점까지 이어진 곳
                min = Math.min(min ,capacity[parent[i]][i] - flow[parent[i]][i]);
            }

            for(int i = dest; i != source; i = parent[i]) {
                flow[parent[i]][i] += min;
                flow[i][parent[i]] -= min;
            }

            totalFlow += min;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        capacity = new int[N + 1][N + 1];
        flow = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++){
         st = new StringTokenizer(br.readLine(), " ");
         int start = Integer.parseInt(st.nextToken());
         int end = Integer.parseInt(st.nextToken());
         int cost = Integer.parseInt(st.nextToken());

         capacity[start][end] += cost;
         capacity[end][start] += cost;
        }

        maxFlow(1, N);

        System.out.println(totalFlow);
    }
}

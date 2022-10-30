import java.util.*;
import java.io.*;

class Edge{
    int start;
    int end;
    int cost;

    Edge(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class Solution {
    static int N;
    static int M;

    static LinkedList<Edge> edges = new LinkedList<>();
    static int parent[];

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static boolean union(int start, int end){
        int startP = find(start);
        int endP = find(end);

        if(startP == endP){
            return false; //union할 필요 x
        }else{
            parent[endP] = startP;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++){
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(start != end){
                edges.add(new Edge(start, end, cost));
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        int count = 0;
        int answer = 0;
        for(Edge temp : edges){
            if(union(temp.start, temp.end)){
                answer += temp.cost;
                count++;

                if(count == N - 1){
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}

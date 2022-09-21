import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    private final int end;
    private final int cost;

    Pair(int e, int c){
        end = e;
        cost = c;
    }

    public int getEnd() {
        return end;
    }
    public int getCost(){
        return cost;
    }

    @Override
    public int compareTo(Pair o) {
        return this.getCost() - o.getCost();
    }
}

public class third {
    static int N;
    static int M;

    static List<Pair> list[];
    static boolean visited[];
    static int distance[];

    public static void dijkstra(int start){
        Queue<Pair> queue = new PriorityQueue<>();

        queue.add(new Pair(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()){
            Pair p = queue.remove();
            int end = p.getEnd();

            if(!visited[end]){
                visited[end] = true;

                for(Pair num : list[end]){
                    int temp = num.getEnd();
                    if(!visited[temp] && distance[temp] >= distance[end] + num.getCost()){
                        int tempSum = distance[end] + num.getCost();
                        distance[temp] = tempSum;
                        queue.add(new Pair(temp, tempSum));
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //N개의 도시
        M = Integer.parseInt(br.readLine()); //M개의 버스

        list = new List[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for(int i = 1; i < N+1; i++){
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end  = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Pair(end, cost));
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(distance[end]);
    }
}
//출발도시번호 - 도착지의 도시 번호 - 버스비용

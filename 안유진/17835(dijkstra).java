import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    private final long end;
    private final long cost;

    Pair(int e, int c){
        end  = e;
        cost = c;
    }
    public long getEnd(){
        return end;
    }
    public long getCost(){
        return cost;
    }
    @Override
    public int compareTo(Pair o) {
        if(this.getCost() - o.getCost() > 0){
            return 1;
        }else if(this.getCost() - o.getCost() == 0){
            return 0;
        }else {
            return -1;
        }
    }
}

public class Bronze {
    static int N;
    static int M;
    static int K;

    static LinkedList<Pair> list[];
    static boolean visited[];
    static long distance[];
    static PriorityQueue<Pair> queue;
    public static void dijkstra(){
        visited = new boolean[N + 1];

        while (!queue.isEmpty()){
            Pair p = queue.remove();
            long end = p.getEnd();

            if(!visited[(int) end]){
                visited[(int) end] = true;

                for(Pair num : list[(int) end]){
                    long temp = num.getEnd();
                    if(visited[(int) temp]){
                        continue;
                    }
                    if(distance[(int) temp] >= distance[(int) end] + num.getCost()){
                        long tempSum = distance[(int) end] + num.getCost();
                        distance[(int) temp] = tempSum;
                        queue.add(new Pair((int) temp, (int) tempSum));
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new LinkedList[N + 1];
        distance = new long[N + 1];

        for(int i = 1; i < N + 1; i++){ //노드개수별 list 초기화
            list[i] = new LinkedList<>();
            distance[i] = Long.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){ //연결 노드랑 가중치
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[to].add(new Pair(from, cost));
        }

        st = new StringTokenizer(br.readLine()); //면접장있는 도시들
        queue = new PriorityQueue<>();
        for(int i = 0; i < K; i++){
            int start = Integer.parseInt(st.nextToken());
            distance[start] = 0;
            queue.add(new Pair(start, 0));
        }

        dijkstra();

        long max = Long.MIN_VALUE;
        for(int j = 1; j < N + 1; j++){
            max = Math.max(distance[j], max);
        }

        for(int j = 1; j < N + 1; j++){
            if(distance[j] == max){
                System.out.println(j);
                System.out.println(distance[j]);
                break;
            }
        }
    }
}

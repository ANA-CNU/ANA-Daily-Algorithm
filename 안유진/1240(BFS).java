import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    private int end;
    private int cost;

    Pair(int e, int c){
        end = e;
        cost = c;
    }
    public int getEnd(){
        return end;
    }
    public int getCost(){
        return cost;
    }
    @Override
    public int compareTo(Pair o){
        return this.getEnd() - o.getEnd();
    }
}

public class Main {
    static int N;
    static int M;
    static boolean visited[];
    static LinkedList<Pair> list[];

    public static int bfs(int start, int end){
        visited = new boolean[N + 1];
        Queue <Pair> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new Pair(start, 0));

        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int here = p.getEnd();
            int hereCost = p.getCost();
            visited[here] = true;

            if(here == end){
                return hereCost;
            }
            for(Pair edge : list[here]) {
                int there = edge.getEnd();
                int thereCost = hereCost + edge.getCost();
                if (visited[there]) continue;
                Pair np = new Pair(there, thereCost);
                queue.add(np);
            }
        }
        return 0;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N + 1];
        for(int i = 0; i < N+1; i++){
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Pair(end, cost));
            list[end].add(new Pair(start, cost));

            Collections.sort(list[start]);
            Collections.sort(list[end]);
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, end)).append('\n');
        }
        System.out.println(sb);
    }
}

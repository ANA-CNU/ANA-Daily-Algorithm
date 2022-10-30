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
    static int V;
    static int E;
    static LinkedList<Edge> list = new LinkedList<>();
    static int mama[];

    public static int find(int x){
        if(mama[x] == x){
            return x;
        }else{
            mama[x] = find(mama[x]);
        }
        return mama[x];
    }

    public static boolean union(int start, int end){
        int startParent = find(start);
        int endParent = find(end);

        if(startParent == endParent){
            return false;
        }else{
            mama[endParent] = startParent;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, end, cost));
        }

        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        }); //cost순으로 정렬

        mama = new int[V + 1];
        for(int i = 0; i < V + 1; i++){
            mama[i] = i;
        }

        int count = 0;
        long answer = 0;

        for(Edge temp : list){
            if(union(temp.start, temp.end)){
                answer += temp.cost;
                count++;

                if(count == V-1){
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
//1. 하나씩 간선작은거 뽑앗
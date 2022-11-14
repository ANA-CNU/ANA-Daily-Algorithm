import java.io.*;
import java.util.*;


public class Second {
    static int N;
    static int M;

    static LinkedList<Edge> list;
    static long distance[];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        list = new LinkedList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, to, cost));
        }

        distance[1] = 0;
        boolean flag = true;

        for(int i = 1; i < N + 1; i++) {
            for(Edge now : list){
                if(distance[now.start] == Long.MAX_VALUE) {
                    continue;
                }
                if(distance[now.end] > distance[now.start] + now.cost) {
                    distance[now.end] = distance[now.start] + now.cost;

                    if(i == N) {
                        flag = false;
                        sb.append(-1);
                        break;
                    }
                }
            }
            if(!flag){
                break;
            }
        }
        if(!flag) {
            System.out.println(sb);
        }else{
            for(int i = 2; i < N + 1; i++){
                if(distance[i] == Long.MAX_VALUE){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(distance[i]).append('\n');
                }
            }
            System.out.println(sb);
        }
    }
}
class Edge{
    int start;
    int end;
    int cost;
    Edge(int s, int e, int c) {
        start = s;
        end = e;
        cost = c;
    }
}

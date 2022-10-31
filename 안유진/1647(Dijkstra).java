import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Node{
    int start;
    int end;
    int value;

    Node(int s, int e, int v){
        start = s;
        end = e;
        value = v;
    }
}

public class Main {
    static int V;
    static int E;
    static LinkedList<Node> list;
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
            return false;
        }else{
            parent[endP] = startP;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();
        parent = new int[V + 1];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.add(new Node(start, end, value));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });

        for(int i = 0; i < V + 1; i++){
            parent[i] = i; //처음시작 부모는 자기자신신
        }

        int count = 0; //간선의 개수
        long answer = 0;

        int max = Integer.MIN_VALUE;
        for(Node n : list){
            if(union(n.start, n.end)){
                answer += n.value;
                max = Math.max(n.value, max);
                count++;

                if(count == V-1){
                    break;
                }
            }
        }
        System.out.println(answer - max);
    }
}

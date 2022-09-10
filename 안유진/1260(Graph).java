import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Rulu {
    static int N;
    static int M;
    static int V;

    static boolean check[];
    static boolean visited[];

    static LinkedList<Integer> linkedList[];
    static StringBuilder sb;
    static StringBuilder DFSsb;

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        check[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int temp = queue.remove();
            sb.append(temp).append(" ");
            for(int num : linkedList[temp]){
                if(!check[num]){
                    check[num] = true;
                    queue.add(num);
                }
            }
        }
    }
    static void DFS(int start){
        visited[start] = true;
        DFSsb.append(start).append(" ");

        for(int temp : linkedList[start]){
            if(!visited[temp]){
                DFS(temp);
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        DFSsb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        linkedList = new LinkedList[N + 1];
        check = new boolean[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            linkedList[i] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            linkedList[start].add(end);
            linkedList[end].add(start);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(linkedList[i]);
        }

        DFS(V);
        BFS(V);

        System.out.println(DFSsb);
        System.out.println(sb);
    }
}

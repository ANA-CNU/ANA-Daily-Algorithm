import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] graph;

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        System.out.print( v + " " );

        while ( !q.isEmpty() ) {
            int now = q.poll();
            for ( int i = 1 ; i < graph.length ; i++ )
                if ( graph[now][i] == 1 && visited[i] == false ) {
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
        }
    }
    static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for ( int i = 0 ; i < graph.length ; i++ )
            if ( graph[v][i] == 1 && visited[i] == false )
                DFS(i);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        while ( m-- > 0 ) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        visited = new boolean[n+1];
        DFS(v);
        System.out.println();

        visited = new boolean[n+1];
        BFS(v);
    }
}
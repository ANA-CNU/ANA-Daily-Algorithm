import java.io.*;
import java.util.*;

public class s2606 {
    static int cnt;
    static boolean[] visited;
    static List[] computers;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int com = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        visited = new boolean[com+1];
        computers = new ArrayList[com+1];

        for ( int i = 1 ; i <= com ; i++ )
            computers[i] = new ArrayList<Integer>();

        while ( t-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }

        cnt = 0;
        DFS(1);

        System.out.println(cnt-1);
    }

    public static void DFS(int v) {
        if ( !visited[v] ) {
            visited[v] = true;
            cnt++;

            for ( int i = 0 ; i < computers[v].size() ; i++ )
                DFS((int)computers[v].get(i));
        }
    }
}
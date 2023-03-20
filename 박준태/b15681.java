import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b15681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Graph g = new Graph(n);
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.addEdge(u,v);
        }
        g.dfs(r);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++){
            int k = Integer.parseInt(br.readLine());
            sb.append(g.dp[k]).append("\n");
        }
        System.out.println(sb);
    }
}
class Graph{
    int[] dp;
    LinkedList<Integer>[] adj;

    public Graph(int n) {
        adj = new LinkedList[n+1];
        for(int i=0; i<n+1; i++){
            adj[i]=new LinkedList<>();
        }
        dp = new int[n+1];
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public int dfs(int R){
        dp[R]=1;
        for (int i : adj[R]) {
            if(dp[i]==0){
                dp[R]+=dfs(i);
            }
        }
        return dp[R];
    }
}
class Node{
    Node child;
    int data;

    public Node(Node child, int data) {
        this.child = child;
        this.data = data;
    }
}
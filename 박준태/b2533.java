
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b2533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Graph g = new Graph(n);
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.addEdge(u,v);
        }
        int[] tmp = g.dfs(1);
        System.out.println(Math.min(tmp[0],tmp[1]));
    }
}
class Graph{
    LinkedList<Integer>[] adj;

    int[][] dp;
    boolean[] visit;
    public Graph(int n) {
        adj = new LinkedList[n+1];
        for(int i=0; i<n+1; i++){
            adj[i] = new LinkedList<>();
        }
        dp = new int[n+1][2];
//        for(int i=0; i<n+1; i++){
//            Arrays.fill(dp[i],100000000);
//        }
        visit = new boolean[n+1];
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public int[] dfs(int R){
        dp[R][0]=0;//자기자신이 얼리아답터가 아니다.
        dp[R][1]=1;//자기자신이 얼리아답터다.
        //leaf 노드 정의

        visit[R]=true;
        for (int i : adj[R]) {
            if(visit[i])continue;
            int[] tmp = dfs(i);
            dp[R][0]+=tmp[1];//자신이 얼리어 답터가 아니면 자식 노드는 모두 얼리아답터이다.
            dp[R][1]+=Math.min(tmp[0],tmp[1]);//자신이 얼리어 답터이면 아래에서 최소값을 가져온다.
        }
        return dp[R];
    }
}
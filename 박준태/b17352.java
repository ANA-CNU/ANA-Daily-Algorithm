import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b17352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph g = new Graph(N);
        for(int i=1; i<=N; i++){
            g.parent[i]=i;
        }
        for(int i=0; i<N-2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.union_root(u,v);
        }
        for(int i=1; i<=N; i++){
            int a = g.find_root(1);
            int b = g.find_root(i);
            if(a!=b){
                System.out.println(1+" "+i);
                break;
            }
        }
    }
}
class Graph{
    int N;
    LinkedList<Integer>[] adj;
    int[] parent;
    boolean[] visit;
    public Graph(int N){
        adj = new LinkedList[N+1];
        for(int i=0; i<=N; i++){
            adj[i]=new LinkedList<>();
        }
        this.N = N;
        parent = new int[N+1];
        visit = new boolean[N+1];
    }
    public void addEdge(int u, int v){
//        adj[u].add(v);
//        adj[v].add(u);
        parent[u]=v;
    }

    public int find_root(int x){
        if(x==parent[x]) return x;
        return parent[x]=find_root(parent[x]);
    }
    //1 2, 2 3, 4 5
    public void union_root(int x, int y){
        x=find_root(x);//1 2 4
        y=find_root(y);//2 3 5
        if(x!=y){
            parent[x]=y;//[2,2,3,4,5] [2,3,3,4,5] [2,3,3,5,5]
        }
    }
//    public void dfs(int R){
//        if(visit[R]){
//            return;
//        }
//        for(int i : adj[R]){
//            visit[i]=true;
//            parent[i]=R;
//            dfs(i);
//        }
//    }
}
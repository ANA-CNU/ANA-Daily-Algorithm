import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph g = new Graph(N);
        for(int i=0; i<=N; i++){
            g.parent[i]=i;
        }//부모 노드 초기화
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(command==0){
                g.union_root(a,b);
            }
            else{
                int x = g.find_root(a);
                int y = g.find_root(b);
                if(x==y){
                    sb.append("YES").append("\n");
                }
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
class Graph{
    int[] parent;
    int[] depth;
    public Graph(int N){
        parent = new int[N+1];
        depth = new int[N+1];
    }
    public int find_root(int x){
        if(x==parent[x]) return x;
        return parent[x]=find_root(parent[x]);
    }
    public void union_root(int x, int y){
        x=find_root(x);
        y=find_root(y);
        if(x!=y){
            if(depth[x]>=depth[y]){
                parent[y]=x;
            }else parent[x]=y;
            if(depth[x]==depth[y]){
                ++depth[x];
            }
        }
    }
}
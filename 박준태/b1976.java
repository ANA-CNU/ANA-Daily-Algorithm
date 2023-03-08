import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] city = new int[N+1][N+1];

        Graph g = new Graph(N);
        for(int i=0; i<=N; i++){
            g.parent[i]=i;
        }//parent 초기화

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }//연결 테이블 정의

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(city[i][j]==1){
                    g.union_root(i,j);
                }
            }
        }//group 연결

        st = new StringTokenizer(br.readLine());
        int[] travel = new int[M];
        for(int i=0; i<M; i++){
            travel[i] = Integer.parseInt(st.nextToken());
        }
        String tmp = null;
        for(int i=0; i<M; i++){
            int a = g.find_root(travel[0]);
            int b = g.find_root(travel[i]);
            if(a!=b){
                tmp = "NO";
                break;
            }
            else{
                tmp = "YES";
            }
        }
        System.out.println(tmp);
    }
}
class Graph{
    int[] parent;
    int[] depth;
    public Graph(int n){
        parent = new int[n+1];
        depth = new int[n+1];
    }

    public int find_root(int x){
        if(x==parent[x]) return x;
        return parent[x]=find_root(parent[x]);
    }
    public void union_root(int x, int y){
        x = find_root(x);
        y = find_root(y);
        if(x!=y){
            if(depth[x]>=depth[y]){
                parent[y]=x;
            }else parent[x]=y;
            if(depth[x]==depth[y]){
                ++depth[y];
            }
        }
    }
}
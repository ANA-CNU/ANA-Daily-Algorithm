import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//도시의 수
        int m = Integer.parseInt(st.nextToken());//도로의 수
        Graph g = new Graph(n);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.addEdge(u,v);
            //간선 연결
        }
        int q = Integer.parseInt(br.readLine());//간선 수정 수
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<q; k++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(a==1){
                g.addEdge(i,j);
                g.bfs(1);
                for (int i1=1;i1<g.cityLn.length; i1++) {
                    sb.append(g.cityLn[i1]).append(" ");
                }
                sb.append("\n");
                //간선 추가
            }else {
                g.removeEdge(i,j);
                g.bfs(1);
                for (int i1=1;i1<g.cityLn.length; i1++) {
                    sb.append(g.cityLn[i1]).append(" ");
                }
                sb.append("\n");
                //간선 삭제
            }
            g.visit=new boolean[n+1];
            Arrays.fill(g.cityLn,-1);
        }
        System.out.println(sb);
    }
}
class Graph{
    LinkedList<Integer>[] adj;
    boolean[] visit;

    int[] cityLn;

    Queue<Node> queue;

    public Graph(int n) {
        adj = new LinkedList[n+1];
        visit = new boolean[n+1];
        for(int i=0; i<=n; i++){
            adj[i]=new LinkedList<>();
        }
        cityLn = new int[n+1];
        Arrays.fill(cityLn,-1);
        queue = new LinkedList<>();
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public void removeEdge(int u, int v){
        adj[u].removeIf(i->i==v);
        adj[v].removeIf(i->i==u);
    }

    public void bfs(int R){
        queue.add(new Node(R,0));
        cityLn[R]=0;
        visit[R]=true;
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            cityLn[tmp.idx]= tmp.cnt;
            for (int i : adj[tmp.idx]) {
                if(!visit[i]){
                    queue.add(new Node(i, tmp.cnt+1));
                    visit[i]=true;
                }
            }
        }
    }
}
class Node{
    int idx;
    int cnt;

    public Node(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}
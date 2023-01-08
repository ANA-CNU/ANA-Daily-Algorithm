import java.util.*;
import java.io.*;

public class Main_1 {
    static PriorityQueue<Edge> EDGE_LIST = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        Node[] nodeList=new Node[N];
        parent=new int[N+1];

        for(int i=0;i<N;i++){
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(s.nextToken());
            int y=Integer.parseInt(s.nextToken());
            int z=Integer.parseInt(s.nextToken());

            nodeList[i]=new Node(i+1,x,y,z);
            parent[i+1]=i+1;
        }

        addEdge_x(nodeList); // x에 대한 정렬
        addEdge_y(nodeList); // y에 대한 정렬
        addEdge_z(nodeList); // z에 대한 정렬

        System.out.println(union());
    }

    public static int find(int child){
        int c=child;
        while(c!=parent[c]) c=parent[c];
        return c;
    }

    public static long union(){
        long ans=0;

        while(!EDGE_LIST.isEmpty()){
            Edge c=EDGE_LIST.poll();
            int A=find(c.from);
            int B=find(c.to);

            if(A!=B){
                ans+=c.value;
                parent[Math.max(A,B)]=Math.min(A,B);
            }
        }

        return ans;
    }

    public static void addEdge_x(Node[] nodeList){
        Arrays.sort(nodeList,Comparator.comparingInt(o -> o.x));
        for(int i=0;i<nodeList.length-1;i++){
            EDGE_LIST.offer(new Edge(nodeList[i].num,nodeList[i+1].num,Math.abs(nodeList[i].x-nodeList[i+1].x)));
            // 정렬 후 index 가 인접한 두 요소는 가장 가까운 거리를 가진다.
        }
    }
    public static void addEdge_y(Node[] nodeList){
        Arrays.sort(nodeList,Comparator.comparingInt(o -> o.y));
        for(int i=0;i<nodeList.length-1;i++){
            EDGE_LIST.offer(new Edge(nodeList[i].num,nodeList[i+1].num,Math.abs(nodeList[i].y-nodeList[i+1].y)));
        }
    }
    public static void addEdge_z(Node[] nodeList){
        Arrays.sort(nodeList,Comparator.comparingInt(o -> o.z));
        for(int i=0;i<nodeList.length-1;i++){
            EDGE_LIST.offer(new Edge(nodeList[i].num,nodeList[i+1].num,Math.abs(nodeList[i].z-nodeList[i+1].z)));
        }
    }
}

class Node{
    int num;
    int x;
    int y;
    int z;

    Node(int n,int xx,int yy,int zz){
        num=n;
        x=xx;
        y=yy;
        z=zz;
    }
}

class Edge{
    int from;
    int to;
    int value;

    Edge(int f, int t,int v) {
        from = f;
        to = t;
        value=v;
    }
}
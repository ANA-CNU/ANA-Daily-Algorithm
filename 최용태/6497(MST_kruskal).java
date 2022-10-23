import java.util.*;
import java.io.*;

public class Algorithm_Field {
    static NodeAndValue[] EDGE_INFO;
    static int[] UNION_INFO;
    static int ans=0;


    public static int find(int startNode){
        int c=startNode;
        while (UNION_INFO[c] != c) c = UNION_INFO[c];
        return c;
    }
    public static void union(){
        for(int i=0;i< EDGE_INFO.length;i++){
            NodeAndValue current=EDGE_INFO[i];
            int f=find(current.fromNode);
            int e=find(current.endNode);
            if(f!=e) UNION_INFO[Math.max(f,e)]=Math.min(f,e);
            else ans+=current.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       while(true) {
           StringTokenizer s=new StringTokenizer(br.readLine()," ");
           int N = Integer.parseInt(s.nextToken());
           int M = Integer.parseInt(s.nextToken());
           ans=0;
           if(N==0 && M==0) break;

           UNION_INFO = new int[N];
           EDGE_INFO = new NodeAndValue[M];

           for (int i = 0; i < N; i++) {
               UNION_INFO[i] = i;
           }

           for (int i = 0; i < M; i++) {
               StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
               int from = Integer.parseInt(ss.nextToken());
               int to = Integer.parseInt(ss.nextToken());
               int v = Integer.parseInt(ss.nextToken());

               EDGE_INFO[i] = new NodeAndValue(from, to, v);
           }

           Arrays.sort(EDGE_INFO, (o1, o2) -> o1.value - o2.value);
           union();
           bw.write(ans+"\n");
       }
       bw.flush();
    }
}



class NodeAndValue {
    int fromNode;
    int endNode;
    int value;

    NodeAndValue(int f, int e, int v){
        fromNode=f;
        endNode=e;
        value=v;
    }
}
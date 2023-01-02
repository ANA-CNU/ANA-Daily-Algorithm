import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Edge> src=new ArrayList<>();
    static int[] UNION_INFO;
    public static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int value;

        Edge(int s,int e,int v){
            start=s;
            end=e;
            value=v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value-o.value;
        }
    }
    public static int find(int v){
        int c=v;
        while(c!=UNION_INFO[c]) c=UNION_INFO[c];
        return c;
    }

    public static int union(){
        int ans=0;
        int max=0;
        for (Edge givenEdge : src) {
            int A = find(givenEdge.start);
            int B = find(givenEdge.end);

            if (A != B) {
                UNION_INFO[Math.min(A, B)] = Math.max(A, B);
                max=Math.max(givenEdge.value,max);
                ans += givenEdge.value;
            }
        }
        return ans-max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(s.nextToken());
        int M=Integer.parseInt(s.nextToken());

        UNION_INFO=new int[N+1];
        for(int i=1;i<N+1;i++) UNION_INFO[i]=i;

        for(int i=0;i<M;i++){
            StringTokenizer x=new StringTokenizer(br.readLine()," ");
            int f=Integer.parseInt(x.nextToken());
            int t=Integer.parseInt(x.nextToken());
            int v=Integer.parseInt(x.nextToken());

            src.add(new Edge(f,t,v));
        }

        Collections.sort(src);

        System.out.println(union());
    }
}
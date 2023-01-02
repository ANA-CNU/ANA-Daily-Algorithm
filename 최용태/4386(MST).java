import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Edge> src=new ArrayList<>();
    static int[] UNION_INFO;

    public static class Pair{
        double x;
        double y;

        Pair(double xx,double yy){
            x=xx;
            y=yy;
        }

        public double distance(Pair o){
            return Math.sqrt(Math.pow(o.x-this.x,2)+Math.pow(o.y-this.y,2));
        }
    }

    public static class Edge implements Comparable<Edge>{
        int start;
        int end;
        double value;

        Edge(int s,int e,double v){
            start=s;
            end=e;
            value=v;
        }

        @Override
        public int compareTo(Edge o) {
            return (int)(this.value-o.value);
        }
    }


    public static int find(int v){
        int c=v;
        while(c!=UNION_INFO[c]) c=UNION_INFO[c];
        return c;
    }

    public static double union(){
        double ans=0;
        for (Edge givenEdge : src) {
            int A = find(givenEdge.start);
            int B = find(givenEdge.end);

            if (A != B) {
                UNION_INFO[Math.min(A, B)] = Math.max(A, B);
                ans += givenEdge.value;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        UNION_INFO=new int[N+1];
        Pair[] dot=new Pair[N+1];
        for(int i=1;i<N+1;i++){
            StringTokenizer x=new StringTokenizer(br.readLine()," ");
            double X=Double.parseDouble(x.nextToken());
            double Y=Double.parseDouble(x.nextToken());
            dot[i]=new Pair(X,Y);
            UNION_INFO[i]=i;
        }

        for(int i=1;i<N+1;i++){
            for(int j=i+1;j<N+1;j++) {
                double v=dot[i].distance(dot[j]);
                src.add(new Edge(i,j,v));
            }
        }

        Collections.sort(src);
        System.out.printf("%.2f",union());

    }
}
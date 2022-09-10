import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N=0;
    static ArrayList<Pair>[] a;
    public static class Pair{
        int node=0;
        int depth=0;

        Pair(int n,int d){
            node=n;
            depth=d;
        }
    }

    public static void run() throws IOException {
       N=Integer.parseInt(br.readLine());
       StringTokenizer s=new StringTokenizer(br.readLine()," ");
       int n=Integer.parseInt(br.readLine());

       int S=Integer.parseInt(s.nextToken());
       int E=Integer.parseInt(s.nextToken());
       a=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            a[i]=new ArrayList<Pair>();
        }
       for(int i=0;i<n;i++){
           StringTokenizer x=new StringTokenizer(br.readLine()," ");
           int from=Integer.parseInt(x.nextToken());
           int to=Integer.parseInt(x.nextToken());

           a[from].add(new Pair(to,0));
           a[to].add(new Pair(from,0));
       }
        System.out.println(BFS(S,E));
    }

    public static int BFS(int S,int E){
        int result=-1;
        boolean visited[]=new boolean[N+1];
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(S,0));


        while(!q.isEmpty()){
            Pair currentPair=q.remove();
            for(int i=0;i<a[currentPair.node].size();i++){
                Pair adjPair=a[currentPair.node].get(i);
                if(!visited[adjPair.node]){
                    if(adjPair.node==E){
                        result=currentPair.depth+1;
                        break;
                    }
                    q.add(new Pair(adjPair.node, currentPair.depth+1));
                    visited[adjPair.node]=true;
                }
            }
        }


        return result;
    }
    public static void main(String[] args) throws IOException {
        run();
    }
}
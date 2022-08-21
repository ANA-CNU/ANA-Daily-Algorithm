import java.util.*;
import java.io.*;


public class Main {
    static ArrayList<Integer>[] a;
    static HashMap<Integer,Pair> HM=new HashMap<Integer,Pair>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N=0;
    public static class Queue{
        int front=-1;
        int rear=-1;
        int[] data;
        Queue(int size){
            data=new int[size];
        }

        void eq(int i){
            data[++rear]=i;
        }
        int dq(){
            if(isEmpty())
                return -1;

            return data[++front];
        }

        boolean isEmpty(){
            return (rear==front);
        }
    }
    public static class Pair{
        int depth=0;
        int child=0;
        int sum=0;

        Pair(int d,int c){
            depth=d;
            child=c;
            sum=depth+child;
        }
    }
    public static void BFS() throws IOException {
        boolean visited[]=new boolean[N+1];
        int parent[]=new int[N+1];
        int vtxOrder[]=new int[N];
        int child=0;

        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            vtxOrder[i]=Integer.parseInt(s.nextToken());
        }
        int isCorrect=0;

        if(vtxOrder[0]==1) {
            isCorrect=1;
            visited[1]=true;
            Queue q=new Queue(N+1);
            Queue d=new Queue(N+1);
            q.eq(1);
            d.eq(0);
            while (!q.isEmpty()) {
                int c = q.dq();
                int depth=d.dq();
                child++;
                for (int i = 0; i < a[c].size(); i++) {
                    int vtx = a[c].get(i);
                    if (!visited[vtx]) {
                        visited[vtx] = true;
                        q.eq(vtx);
                        parent[vtx]=c;
                        d.eq(depth+1);
                        HM.put(vtx,new Pair(depth+1,child));
                    }
                }
            }

            int current=0;
            int prevDepth=HM.get(vtxOrder[1]).sum;

            for(int i=1;i<N;i++){
                int currentDepth=HM.get(vtxOrder[i]).sum;
                if(prevDepth!=currentDepth) current++;

                while(a[vtxOrder[current]].size()<2&& current!=0 && current<N-1) current++;

                if(parent[vtxOrder[i]]!=vtxOrder[current] || HM.get(vtxOrder[i]).depth!=d.dq()) {
                    isCorrect=0;
                    break;
                }
                prevDepth=currentDepth;
            }
        }
        System.out.println(isCorrect);
    }
    public static void search() throws IOException {
        N=Integer.parseInt(br.readLine());
        a=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            a[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int f=Integer.parseInt(s.nextToken());
            int t=Integer.parseInt(s.nextToken());
            a[f].add(t);
            a[t].add(f);
        }
        BFS();
    }

    public static void main(String[] args) throws IOException {
        search();
    }
}

               /* System.out.println("i: "+i);
                System.out.println("current: "+current);
                System.out.println("prevDepth: "+prevDepth);
                System.out.println("currentDepth: "+currentDepth);
                System.out.println("vtxOrder[current]: "+vtxOrder[current]);
                System.out.println("vtxOrder[i]: "+vtxOrder[i]);
                System.out.println("---------------------");*/
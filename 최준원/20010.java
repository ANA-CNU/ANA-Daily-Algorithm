import java.io.*;
import java.util.*;

public class Main {
    static int[] uf;

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        uf[x] = y;
    }
    static int find(int x) {
        if (uf[x] == x) return x;
        else return uf[x] = find(uf[x]);
    }
    static boolean[] vi;
    static ArrayList<int[]>[] k;
    static long Max=0;
    static int n=-1;
    static void dfs(int x,long p){
        vi[x]=true;
        boolean f=false;
        for(int[] q:k[x]){
            if(vi[q[0]]) continue;
            dfs(q[0],p+q[1]);
            f=true;
        }
        if(!f){
            if(Max<p){
                Max=p;
                n=x;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> ka=new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        String[] s = bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
        k=new ArrayList[a]; for(int i=0; i<a; i++) k[i]=new ArrayList<>();
        vi=new boolean[a]; uf=new int[a]; for(int i=0; i<a; i++) uf[i]=i;
        while(b-->0){
            s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]),z=Integer.parseInt(s[2]);
            ka.add(new int[]{x,y,z});
        }
        long sum=0;
        while(!ka.isEmpty()){
            int[] p=ka.poll();
            if(find(p[0])==find(p[1])) continue;
            union(p[0],p[1]);
            sum+=p[2];
            k[p[0]].add(new int[]{p[1],p[2]});
            k[p[1]].add(new int[]{p[0],p[2]});
        }
        System.out.println(sum);
        dfs(0,0);
        Arrays.fill(vi,false); Max=0;
        dfs(n,0);
        System.out.println(Max);
    }
}

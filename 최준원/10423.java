import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] k;
    static int[] uf;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> ka=new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        String[] s = bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]),c=Integer.parseInt(s[2]);
        k=new ArrayList[a+1]; uf=new int[a+1]; boolean[] light=new boolean[a+1];
        for(int i=1; i<=a; i++) {
            uf[i]=i;
            k[i]=new ArrayList<>();
        }
        s = bf.readLine().split(" ");
        for(String i:s) light[Integer.parseInt(i)]=true;
        while(b-->0){
            s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]),z=Integer.parseInt(s[2]);
            k[x].add(new int[]{x,y,z});
            k[y].add(new int[]{y,x,z});
        }
        for(int i=1; i<=a; i++) if(light[i]) ka.addAll(k[i]);
        long sum=0;
        while(c<a){
            int[] p=ka.poll();
            int x=find(p[0]),y=find(p[1]);
            if(light[y]){
                int tmp=x;
                x=y;
                y=tmp;
            }
            if(!light[x]||!light[y]){
                union(x,y);
                sum+=p[2];
                c++;
                if(!light[x]) ka.addAll(k[x]);
                else ka.addAll(k[y]);
            }
        }
        System.out.println(sum);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        uf[y] = x;
    }

    static int find(int x) {
        if (uf[x] == x) return x;
        else return uf[x] = find(uf[x]);
    }
}

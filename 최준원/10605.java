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
    static ArrayList<int[]>[] k;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]),c=Integer.parseInt(s[2]);
            if(a==b && b==c && c==0) break;
            k=new ArrayList[a+1]; for(int i=1; i<=a; i++) k[i]=new ArrayList<>();
            uf=new int[a+1]; for(int i=1; i<=a; i++) uf[i]=i;
            while(b-->0){
                s = bf.readLine().split(" ");
                int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
                union(x,y);
            }
            while(c-->0){
                s = bf.readLine().split(" ");
                int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]), z = Integer.parseInt(s[2]);
                k[find(x)].add(new int[]{y,z});
            }
            long sum=0;
            for(int i=1; i<=a; i++){
                if(k[i].size()==0) continue;
                k[i].sort((o1, o2) -> o2[1] - o1[1]);
                int tmp=0,j=0,min=0;
                for(; j<k[i].size(); j++){
                    tmp+=k[i].get(j)[0];
                    if(min+tmp>=k[i].get(j)[1]+1){
                        min=Math.max(min,k[i].get(j)[1]+1);
                        break;
                    }
                    if(j==k[i].size()-1 || k[i].get(j+1)[1]!=k[i].get(j)[1]) {
                        min+=tmp;
                        tmp=0;
                    }
                }
                sum+=min;
            }
            System.out.println(sum);
        }
    }
}

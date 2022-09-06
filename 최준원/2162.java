import java.io.*;
import java.util.*;

class pair{
    int first,second;
    pair(int f,int s){
        first=f;
        second=s;
    }
}

public class Main {
    static int[] uf;
    static int[] size;
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        uf[x] = y;
        size[y]+=size[x];
    }

    static int find(int x) {
        if (uf[x] == x) return x;
        else return uf[x] = find(uf[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(bf.readLine());
        pair[][] k=new pair[a][2];
        uf=new int[a]; for(int i=0; i<a; i++) uf[i]=i;
        size=new int[a]; Arrays.fill(size,1);
        for(int i=0; i<a; i++){
            String[] s = bf.readLine().split(" ");
            for(int j=0; j<2; j++){
                k[i][j]=new pair(Integer.parseInt(s[2*j]),Integer.parseInt(s[2*j+1]));
            }
        }
        for(int i=0; i<a; i++){
            for(int j=i+1; j<a; j++){
                if(sect(k[i],k[j])){
                    union(i,j);
                }
            }
        }
        int max=-1;
        HashSet<Integer> ka=new HashSet<>();
        for(int i=0; i<a; i++){
            ka.add(find(i));
            max=Math.max(size[find(i)],max);
        }
        System.out.println(ka.size());
        System.out.println(max);
    }
    static int ccw(pair a,pair b,pair c){
        long k=a.first*b.second+b.first*c.second+c.first*a.second;
        k-=a.second*b.first+b.second*c.first+c.second*a.first;
        if(k==0) return 0;
        else return k>0?1:-1;
    }
    static boolean sect(pair[] x,pair[] y){
        int a=ccw(x[0],x[1],y[0]),b=ccw(x[0],x[1],y[1]);
        int c=ccw(y[0],y[1],x[0]),d=ccw(y[0],y[1],x[1]);
        if(a*b==0 && c*d==0){
            int xx1=Math.max(x[0].first,x[1].first),xx2=Math.min(x[0].first,x[1].first);
            int xy1=Math.max(x[0].second,x[1].second),xy2=Math.min(x[0].second,x[1].second);
            int yx1=Math.max(y[0].first,y[1].first),yx2=Math.min(y[0].first,y[1].first);
            int yy1=Math.max(y[0].second,y[1].second),yy2=Math.min(y[0].second,y[1].second);
            return xx1 >= yx2 && yx1 >= xx2 && xy1 >= yy2 && yy1 >= xy2;
        }
        else return a*b<=0 && c*d<=0;
    }
}

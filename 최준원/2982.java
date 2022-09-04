import java.io.*;
import java.util.*;

public class Main {
    static int[][][] block;
    static int[][] k;
    static int[] vi,vik;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> ka=new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        String[] s = bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
        block=new int[a+1][a+1][2]; k=new int[a+1][a+1]; vi=new int[a+1];
        s = bf.readLine().split(" ");
        int st=Integer.parseInt(s[0]),fi=Integer.parseInt(s[1]),t=Integer.parseInt(s[2]),l=Integer.parseInt(s[3]);
        vik=new int[a+1];
        s = bf.readLine().split(" ");
        for(int i=0; i<l; i++) vik[i]=Integer.parseInt(s[i]);
        while(b-->0){
            s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]), z = Integer.parseInt(s[2]);
            k[x][y]=z; k[y][x]=z;
        }
        int ll=0;
        for(int i=0; i<l-1; i++){
            block[vik[i+1]][vik[i]][0]=block[vik[i]][vik[i+1]][0]=ll;
            block[vik[i+1]][vik[i]][1]=block[vik[i]][vik[i+1]][1]=ll+k[vik[i]][vik[i+1]];
            ll+=k[vik[i]][vik[i+1]];
        }
        Arrays.fill(vi,1987654321);
        vi[st]=t;
        ka.add(new int[]{st,t});
        while(!ka.isEmpty()){
            int[] p=ka.poll();
            if(vi[p[0]]<p[1]) continue;
            for(int i=1; i<=a; i++){
                if(k[p[0]][i]==0) continue;
                int tmp=block[p[0]][i][0]<=p[1]&&p[1]<block[p[0]][i][1]?block[p[0]][i][1]:p[1];
                if(vi[i]>tmp+k[p[0]][i]){
                    vi[i]=tmp+k[p[0]][i];
                    ka.add(new int[]{i,vi[i]});
                }
            }
        }
        System.out.println(vi[fi]-t);
    }
}

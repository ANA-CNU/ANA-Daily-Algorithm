import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] vi;
    static char[][] k;
    static int[][] move={{-1,0},{0,-1},{1,0},{0,1}};
    static int max=-1,n=-1,m=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(bf.readLine());
        while (g-- > 0) {
            String[] s = bf.readLine().split(" ");
            max=-1; n=-1; m=-1;
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
            k=new char[y][x]; vi=new boolean[y][x];
            int yy=-1,xx=-1;
            for(int i=0; i<y; i++) {
                char[] sa=bf.readLine().toCharArray();
                for(int j=0; j<x; j++) {
                    k[i][j]=sa[j];
                    if(k[i][j]=='.' && yy==-1){
                        yy=i; xx=j;
                    }
                }
            }
            dfs(yy,xx,0);
            for(int i=0; i<y; i++) {
                Arrays.fill(vi[i],false);
            }
            max=-1;
            dfs(n,m,0);
            System.out.println("Maximum rope length is "+max+".");
        }
    }
    static void dfs(int y,int x,int p){
        vi[y][x]=true;
        boolean f=false;
        for(int i=0; i<4; i++){
            int yy=y+move[i][0];
            int xx=x+move[i][1];
            if(yy>=0 && yy<k.length && xx>=0 && xx<k[0].length && !vi[yy][xx] && k[yy][xx]=='.'){
                dfs(yy,xx,p+1);
                f=true;
            }
        }
        if(!f){
            if(max<p){
                max=p;
                n=y;
                m=x;
            }
        }
    }
}

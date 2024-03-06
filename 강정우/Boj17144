import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17144 {
    static int r, c, t;
    static int[][] map;
    static ArrayList<int[]>air=new ArrayList<>();
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static ArrayList<int[]> dust = new ArrayList<>();
    static  int [][]dust_save;
    static void clean(){
        int []a1=air.get(0);
        int []a2=air.get(1);
        int r1=a1[0];
        int c1=a1[1];
        int r2=a2[0];
        int c2=a2[1];
        map[r1-1][c1]=0;
        map[r2+1][c2]=0;
        for(int i=r1-1;i>0;i--){
            map[i][0]=map[i-1][0];
        }
        for(int i=0;i<c-1;i++){
            map[0][i]=map[0][i+1];
        }
        for(int i=0;i<r1;i++){
            map[i][c-1]=map[i+1][c-1];
        }
        for(int i=c-1;i>1;i--){
            map[r1][i]=map[r1][i-1];
        }
        map[r1][1]=0;
        for(int i=r2+1;i<r-1;i++){
            map[i][0]=map[i+1][0];
        }
        for(int i=0;i<c-1;i++){
            map[r-1][i]=map[r-1][i+1];
        }
        for(int i=r-1;i>r2;i--){
            map[i][c-1]=map[i-1][c-1];
        }
        for(int i=c-1;i>1;i--){
            map[r2][i]=map[r2][i-1];
        }
        map[r2][1]=0;
        dust.clear();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j]> 0){
                    dust.add(new int[]{i,j});
                }
            }
        }
    }
    static void diffusion(){
        dust_save=new int[r][c];
        for (int[] d : dust) {
            int r1 = d[0];
            int c1 = d[1];
            int []s={r1,c1};
            int dust=map[r1][c1];
            int dm=dust/5;
            int cnt=0;
            for(int i=0;i<4;i++){
                int dr=r1+dir[i][0];
                int dc=c1+dir[i][1];
                if(dr<0||dr>=r||dc<0||dc>=c)continue;
                if(map[dr][dc]==-1)continue;
                dust_save[dr][dc]+=dm;
                cnt++;
            }
            dust_save[r1][c1]+=dust-dm*cnt;
        }
        dust.clear();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(dust_save[i][j] > 0){
                    dust.add(new int[]{i,j});
                }
                if((air.get(0)[0]==i&&air.get(0)[1]==j)||(air.get(1)[0]==i&&air.get(1)[1]==j))continue;
                else {
                    map[i][j]=dust_save[i][j];
                }
            }
        }
    }
    static int sum(){
        int sum = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] > 0){
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    air.add(new int[]{i,j});
                } else if (map[i][j] > 0) {
                    dust.add(new int[]{i, j});
                }
            }
        }
        for(int i = 0; i < t; i++){
            diffusion();
            clean();
        }
        System.out.println(sum());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hororop{
    static int M;
    static int N;
    static int K;
    static int arr[][];
    static boolean check[][];
    static int Y[] = {0, -1, 0, 1};
    static int X[] = {-1, 0, 1, 0};

    static void dfs(int x, int y){
        check[x][y] = true;

        for(int i = 0; i < 4; i++){
            int tempx = x + X[i];
            int tempy = y + Y[i];

            if(tempx >= 0 && tempy >= 0 && tempx < M && tempy < N){
                if(!check[tempx][tempy] && arr[tempx][tempy] == 1){
                    dfs(tempx, tempy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st;

       int T = Integer.parseInt(br.readLine());

       while (T --> 0){
           st = new StringTokenizer(br.readLine()," ");

           M = Integer.parseInt(st.nextToken());
           N = Integer.parseInt(st.nextToken());
           K = Integer.parseInt(st.nextToken());

           arr = new int[M][N];
           check = new boolean[M][N];
           for(int i = 0; i < K; i++){
               st = new StringTokenizer(br.readLine()," ");
               int x = Integer.parseInt(st.nextToken());
               int y = Integer.parseInt(st.nextToken());
               arr[x][y] = 1;
           }

           int count = 0;
           for(int x = 0; x < M; x++){
               for(int y = 0; y < N; y++){
                    if(arr[x][y] == 1 && !check[x][y]){
                        dfs(x, y);
                        count++;
                    }
               }
           }
           sb.append(count).append('\n');
       }
        System.out.println(sb);
    }
}

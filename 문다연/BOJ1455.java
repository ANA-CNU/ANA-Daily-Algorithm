package BOJ;
import java.util.*;
import java.io.*;

public class BOJ1141{
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for(int j = 0; j < m ; j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(arr[j][i] == 1) {
                    reverse(j, i);

                    answer += 1;
                }

            }
        }

        System.out.println(answer);
    }

    static void reverse(int x, int y) {
        for(int i = 0; i <= x; i++) {
            for(int j = 0; j <= y; j++) {
                if(arr[i][j] == 1){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }
    }
}
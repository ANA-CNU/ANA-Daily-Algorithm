import java.io.*;
import java.util.*;

public class Main {

    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N+1][3][2];
        int L=0;
        int l=0;
        for (int i = 1; i < N+1; i++) {
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int A=Integer.parseInt(s.nextToken());
            int B=Integer.parseInt(s.nextToken());
            int C=Integer.parseInt(s.nextToken());
            dp[i][0][0]=A+Math.max(dp[i-1][0][0],dp[i-1][1][0]);
            dp[i][1][0]=B+Math.max(dp[i-1][0][0],Math.max(dp[i-1][1][0],dp[i-1][2][0]));
            dp[i][2][0]=C+Math.max(dp[i-1][1][0],dp[i-1][2][0]);

            dp[i][0][1]=A+Math.min(dp[i-1][0][1],dp[i-1][1][1]);
            dp[i][1][1]=B+Math.min(dp[i-1][0][1],Math.min(dp[i-1][1][1],dp[i-1][2][1]));
            dp[i][2][1]=C+Math.min(dp[i-1][1][1],dp[i-1][2][1]);
        }
        L=Math.max(dp[N][0][0],Math.max(dp[N][1][0],dp[N][2][0]));
        l=Math.min(dp[N][0][1],Math.min(dp[N][1][1],dp[N][2][1]));

        System.out.println(L+" "+l);
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static int search() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 9999999;
        int dp[][] = new int[N][3];
        StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
        dp[0][0]=Integer.parseInt(ss.nextToken());
        dp[0][1]=Integer.parseInt(ss.nextToken());
        dp[0][2]=Integer.parseInt(ss.nextToken());

        for (int i = 1; i < N; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                int v= Integer.parseInt(s.nextToken());
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                }

                dp[i][j]+=v;
            }
        }
        for (int i = 0; i <3; i++) {
            result = Math.min(dp[N-1][i], result);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int ans = search();
        System.out.println(ans);
    }
}

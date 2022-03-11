
import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ShinD on 2022-03-11.
 */
@BOJ
public class 백준15988 {



    static long [] dp = new long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;//dp[3] + dp[0]   +   dp[2]+dp[1]   + dp[1] + dp[2], 111, 1 2, 21 3


        //dp[4] = dp[3] + dp[1]   + dp[2]+dp[2] + dp[1] + dp[3]
        for (int i =4; i< dp.length; i++){
            dp[i]= ((dp[i-1]%1000000009) + (dp[i-2]%1000000009) + (dp[i-3]%1000000009))%1000000009;
        }


        int T = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {

            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb.toString());



    }
}

package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        System.out.println(recursion(n));
    }
    static int recursion(int n){
        if(dp[n] != 0) return dp[n];
        else if(n == 1) return dp[1] = 1;
        else if(n == 2) return dp[2] = 2;
        else return dp[n] = (recursion(n-1 ) + recursion(n-2))%10007;
    }
}

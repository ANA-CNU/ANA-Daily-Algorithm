package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];
            sb.append(recursive(n)).append("\n");
        }
        System.out.println(sb);
    }

    static int recursive(int num){
        if(dp[num] != 0) return dp[num];
        if(num == 1) return 1;
        else if(num == 2) return 2;
        else if(num == 3) return 4;
        else return dp[num] = recursive(num-1) + recursive(num-2) + recursive(num-3);
    }
}

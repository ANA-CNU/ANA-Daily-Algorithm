import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");

        int[] dp = new int[n];

        dp[0] = Integer.parseInt(st[0]); 
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1]+Integer.parseInt(st[i]), Integer.parseInt(st[i]));
            max = max < dp[i] ? dp[i] : max;
        }

        System.out.println(max);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int [] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=a;i++){
            dp[i] =  ((dp[i-1]+dp[i-2])%10007);
        }
        System.out.println(dp[a]);
    }
}

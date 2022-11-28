import java.io.*;
import java.util.*;

public class Bronze {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N + 1];
        int dp[] = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];

        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
            for(int i = 3; i < N + 1; i++) {
                dp[i] = Math.max(dp[i-2], dp[i - 3] + arr[i - 1]) + arr[i];
            }
        }

        if(N == 1) {
            System.out.println(dp[1]);
        }else{
            System.out.println(dp[N]);
        }
    }
}


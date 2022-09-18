import java.util.*;
import java.io.*;


public class Main {
    static int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        int[] dp = new int[N + 1];
        int[] a = new int[N+1];

        for(int i=1;i<N+1;i++){
            a[i]=Integer.parseInt(s.nextToken());
            for(int x=1; i+x<N+1 && x<=a[i] ;x++){
                if(i==1 || dp[i]!=0) dp[i+x]=dp[i]+1;
            }
        }

        for (int i = 1; i<N+1; i++) {
            for(int x=1; i+x<N+1 && x<=a[i] ;x++){
                dp[i+x]=Math.min(dp[i]+1,dp[i+x]);
            }
        }

        if(dp[N]==0 && N!=1) dp[N]=-1;
        System.out.println(dp[N]);
    }
}

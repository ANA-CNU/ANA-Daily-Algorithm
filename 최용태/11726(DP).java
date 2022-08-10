import java.io.*;
import java.util.*;

public class Main {

    public static int s(int n){
       int[] dp=new int[n+1];
       int MOD=10007;
       dp[0]=1;
       dp[1]=1;

       for(int i=2;i<n+1;i++){
            dp[i]=((dp[i-1]%MOD)+(dp[i-2]%MOD))%MOD;
       }

       return dp[n];
    }

    public static void main(String[] args) throws IOException {
        int ans=s(ipt());
        System.out.println(ans);
    }

    public static int ipt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}

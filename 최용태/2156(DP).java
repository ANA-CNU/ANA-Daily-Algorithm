import java.util.*;
import java.io.*;


public class Main {
    static int MAX_VALUE = 0;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N=Integer.parseInt(br.readLine());
         int[] dp=new int[N+3];
         int[] a=new int[N+3];

         for(int i=3;i<N+3;i++){
             a[i]=Integer.parseInt(br.readLine());
         }

         for(int i=3;i<N+3;i++){
             dp[i]=Math.max(dp[i-1],Math.max(dp[i-2]+a[i],dp[i-3]+a[i]+a[i-1]));
         }
        System.out.println(dp[N+2]);
    }
}
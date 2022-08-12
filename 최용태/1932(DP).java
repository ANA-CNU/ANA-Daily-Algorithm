import java.io.*;
import java.util.*;

public class Main {
    public static int search() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result=0;
        int N=Integer.parseInt(br.readLine());
        int dp[][]=new int[N+1][N+1];
        dp[1][1]=Integer.parseInt(br.readLine());
        for(int i=2;i<N+1;i++){
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int size=s.countTokens()+1;

            for(int j=1;j<size;j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+Integer.parseInt(s.nextToken());
            }
        }
        for(int i=1;i<N+1;i++){
            result=Math.max(dp[N][i],result);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int ans=search();
        System.out.println(ans);
    }
}

import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int search(int n,int k) throws IOException {
        int [][]dp=new int[n+1][k+1];
        for(int i=1;i<n+1;i++){
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int w=Integer.parseInt(s.nextToken());
            int v=Integer.parseInt(s.nextToken());

            for(int x=1;x<w &&x<=k;x++){
                dp[i][x]=dp[i-1][x];
            }
            for(int x=0;x+w<=k;x++)
                dp[i][x+w]=Math.max(dp[i-1][x+w],dp[i-1][x]+v);
        }

       /* for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                System.out.printf("%2d ",dp[i][j]);
            }
            System.out.println();
        }*/
        
        return dp[n][k];
    }

    public static void run() throws IOException {
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(s.nextToken());
        int K=Integer.parseInt(s.nextToken());
        System.out.println(search(N,K));
    }
    public static void main(String[] args) throws IOException {
        run();
    }
}
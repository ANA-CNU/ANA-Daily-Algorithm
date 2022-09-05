import javax.xml.stream.StreamFilter;
import java.io.*;
import java.util.*;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s=new StringTokenizer(br.readLine()," ");

        int N=Integer.parseInt(s.nextToken());
        int M=Integer.parseInt(s.nextToken());
        int[][] dp=new int[N+1][1000000+1];
        int ans=1;

        for(int i=1;i<=N;i++){
            StringTokenizer ss=new StringTokenizer(br.readLine()," ");
            int w=Integer.parseInt(ss.nextToken());
            int v=Integer.parseInt(ss.nextToken());

            for(int j=0;j<w;j++){
                dp[i][j]= dp[i - 1][j];
            }

            for(int j=w;j<1000000+1;j++) {
                dp[i][j] = Math.max(dp[i-1][j-w] + v, dp[i - 1][j]);
            }
        }

        int W=Integer.parseInt(br.readLine());
        long lrgTop=dp[N][W];
       long lrgBot=W;

        for(int i=2;i<=M;i++){
            W=Integer.parseInt(br.readLine());
            if(lrgTop*W<lrgBot*dp[N][W] ){
                lrgTop=dp[N][W];
                lrgBot=W;
                ans=i;
            }
        }

        System.out.println(ans);
    }
}
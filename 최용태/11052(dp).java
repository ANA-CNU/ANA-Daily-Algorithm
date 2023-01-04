import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    static int getMax(int[] dp,int range){
        int max=0;
        for(int i=1;i<range;i++){
            max=Math.max(max,dp[range-i]+dp[i]);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
            int N=Integer.parseInt(br.readLine());
            StringTokenizer s=new StringTokenizer(br.readLine()," ");
            int[] src=new int[N+1];
            int[] dp=new int[N+1];

            for(int i=1;i<N+1;i++){
                src[i]=Integer.parseInt(s.nextToken());
            }

            for(int i=1;i<N+1;i++){
                dp[i]=Math.max(src[i],getMax(dp,i));
            }

        System.out.println(dp[N]);
    }

}
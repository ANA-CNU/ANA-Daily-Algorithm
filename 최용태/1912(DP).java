import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        int [] a=new int[N];
        int [] dp=new int[N+1];
        a[0]=Integer.parseInt(s.nextToken());
        dp[1]=a[0];
        int max=dp[1];
        for(int i=2;i<N+1;i++){
            a[i-1]=Integer.parseInt(s.nextToken());
            dp[i]=Math.max(dp[i-1]+a[i-1],a[i-1]);
            max=Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
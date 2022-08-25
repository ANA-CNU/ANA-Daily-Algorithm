import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a=br.readLine().toCharArray();
        char[] b=br.readLine().toCharArray();
        int c=b.length;
        int r=a.length;
        int dp[][]=new int[c+1][r+1];

        for(int j=0;j<c;j++){
            for(int i=0;i<r;i++) {
                if (b[j] == a[i])
                    dp[j+1][i+1] = dp[j][i]+1;
                else
                    dp[j+1][i+1] = Math.max(dp[j+1][i],dp[j][i+1]);
            }
        }

        System.out.println(dp[c][r]);
    }
}
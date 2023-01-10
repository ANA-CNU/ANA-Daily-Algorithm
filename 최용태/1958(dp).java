import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        char[] c = br.readLine().toCharArray();
        int x = a.length;
        int y = b.length;
        int z = c.length;
        int[][][] dp = new int[x + 1][y + 1][z + 1];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    if (a[i] == b[j] && a[i] == c[k] && b[j] == c[k])
                        dp[i + 1][j + 1][k + 1] = dp[i][j][k] + 1;
                    else
                        dp[i + 1][j + 1][k + 1] = Math.max(dp[i][j+1][k+1], Math.max(dp[i+1][j][k+1],dp[i+1][j+1][k]));
                }
            }
        }
        System.out.println(dp[x][y][z]);
    }
}
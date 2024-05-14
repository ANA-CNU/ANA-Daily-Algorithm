package Dp;

import java.io.*;

public class backjoon_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();
        char[] ach = new char[a.length() + 1];
        char[] bch = new char[b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            ach[i] = a.charAt(i - 1);
        }
        for (int i = 1; i <= b.length(); i++) {
            bch[i] = b.charAt(i - 1);
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (ach[i] == bch[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        bw.write(dp[a.length()][b.length()] + "\n");
        bw.flush();
        bw.close();
    }
}
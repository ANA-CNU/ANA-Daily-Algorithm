import java.io.*;
import java.util.*;

public class Bronze {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String first = br.readLine();
        String second = br.readLine();

        char firstArr[] = first.toCharArray();
        char secondArr[] = second.toCharArray();

        int fLength = first.length();
        int sLength = second.length();

        int dp[][] = new int[fLength + 1][sLength + 1];

        for(int i = 1; i < fLength + 1; i++) {
            for(int j = 1; j < sLength + 1; j++) {
                if(firstArr[i - 1] == secondArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        sb.append(dp[fLength][sLength]).append('\n');
        System.out.println(sb);
    }
}


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer getToken() throws IOException {
        return new StringTokenizer(br.readLine(), " ");
    }

    public static void main(String[] args) throws IOException {
        int MAX_RISK=0;
        StringTokenizer s = getToken();
        StringTokenizer m = getToken();
        StringTokenizer r = getToken();

        int N = Integer.parseInt(s.nextToken());
        int M = Integer.parseInt(s.nextToken());

        int[] memory = new int[N + 1];
        int[] risk = new int[N + 1];


        for (int i = 1; i < N+1; i++) {
            memory[i] = Integer.parseInt(m.nextToken());
            risk[i] = Integer.parseInt(r.nextToken());
            MAX_RISK+=risk[i];
        }

        int[][] dp=new int[N+1][MAX_RISK+1];

        for(int i = 1; i < N+1; i++){
            for(int currentRisk = 1; currentRisk < MAX_RISK+1; currentRisk++) {
                if(risk[i] > currentRisk)
                    dp[i][currentRisk]=dp[i-1][currentRisk];
                else{
                    dp[i][currentRisk]=Math.max(memory[i]+dp[i-1][currentRisk-risk[i]],dp[i-1][currentRisk]);
                }
            }
        }

        for(int i=1;i<MAX_RISK+1;i++){
            if(M<=dp[N][i]){
                System.out.println(i);
                break;
            }
        }
    }
}

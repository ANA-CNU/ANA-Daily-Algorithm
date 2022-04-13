import java.io.*;

public class 백준_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+2];
        int[] dp = new int[N+2]; // 계단 1칸이면 밑에 0,1,2 값에서 outofindex

        for(int i = 0; i < N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // dp[0] 즉 한 칸 이동에서의 최대는 자기 자신
        dp[0] = stairs[0];
        // dp[1] 은 자기자신과 전칸+자기자신 중 최대
        dp[1] = Math.max(stairs[0]+stairs[1], stairs[1]);
        // dp[2] 는 st[0]+st[2] 또는 st[1]+st[2] 중 최대
        dp[2] =  Math.max(stairs[0]+stairs[2], stairs[1]+stairs[2]);

        for(int i = 3; i < N; i++){
            dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
        }
        System.out.println(dp[N-1]);
    }   
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static int N, K;
    public static long[] arr, prefix;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        arr = new long[N];
        prefix = new long[N];
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = arr[i] + (i == 0 ? 0 : prefix[i-1]);;
        }
        
        long sum = 0;
        dp = new long[K+1][N];
        for (long[] d : dp) Arrays.fill(d, Long.MAX_VALUE);
        
        for (int i=0;i<arr.length;i++) {
            dp[0][i] = (i+1L) * (sum += arr[i]);
        }
        
        for (int i=2;i<=Math.min(K, N);i++) {
            dnc(i-2, N-1, i-1, i-2, N-1);
        }
        
        System.out.println(dp[Math.min(K, N)-1][N-1]);
        
        
    }
    public static void dnc (int left, int right, int round, int s, int e) {
        int mid = left + right >> 1;
        int idx = 0;
        
        dp[round][mid] = Long.MAX_VALUE;
        for (int i=Math.min(e, mid);i>=s;i--) {
            long sum = prefix[mid] - prefix[i];
            if (dp[round][mid] > dp[round-1][i] + (mid - i) * sum) {
                dp[round][mid] = dp[round-1][i] + (mid - i) * sum;
                idx = i;
            }
        }
        
        if (left == right) return;
        dnc(left, mid, round, s, idx);
        dnc(mid+1, right, round, idx, e);
    }
}

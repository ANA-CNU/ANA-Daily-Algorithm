package BOJ;

import java.io.*;
import java.util.*;
import annotation.*;
@BOJ(   number = 1929,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 19))
public class BOJ1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean [] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j+=i) isNotPrime[j] = true;
            }
        }
        for (int m = M; m <= N; m++) {
            if (!isNotPrime[m]) System.out.println(m);
        }
    }
}

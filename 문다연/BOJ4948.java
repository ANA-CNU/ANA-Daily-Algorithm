package BOJ;

import java.io.*;
import annotation.*;
@BOJ(   number = 4948,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 19))
public class BOJ4948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = null;

        boolean [] isPrime;
        while (!(input = br.readLine()).equals("0")) {
            int test_case = Integer.parseInt(input);
            int N = test_case * 2;
            isPrime = new boolean[N + 1];

            isPrime[0] = isPrime[1] = true; // 0 and 1 aren't prime
            int cnt = N - test_case;

            for (int i = 2; i * i <= N; i++) {
                if (!isPrime[i]) {
                    for (int j = i * i; j <= N; j += i) {
                        if (j > test_case && j <= N && !isPrime[j]) cnt--;
                        isPrime[j] = true;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}

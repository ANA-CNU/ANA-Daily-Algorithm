package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import annotation.*;
@BOJ(   number = 3896,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 28))
public class BOJ3896 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = 1299709;
        boolean [] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) prime[j] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int k = Integer.parseInt(br.readLine());
            if (!prime[k]) sb.append(0).append("\n");
            else {
                int min = k - 1, max = k + 1;
                while (min > 2) {
                    if (!prime[min]) break;
                    min--;
                }
                while (max <= N) {
                    if (!prime[max]) break;
                    max++;
                }
                sb.append(max - min).append("\n");
            }
        }
        System.out.println(sb);
    }
}

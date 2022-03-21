package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import annotation.*;
@BOJ(   number = 15965,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 20))

public class BOJ9020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        if (K == 1) {
            System.out.println(2);
            return;
        }
        boolean [] isPrime = new boolean[30 * K + 1];
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= 30 * K; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 30 * K; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        int ptr = 2;
        for (int i = 2; K > 0; i++) {
            if (!isPrime[i]) {
                K--;
                ptr = i;
            }

        }

        System.out.println(ptr);
    }
}

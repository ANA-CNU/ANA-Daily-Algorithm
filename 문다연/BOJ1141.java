package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import annotation.*;
@BOJ(   number = 1141,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 23))
public class BOJ1141 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] words = new String[N];
        for (int n = 0; n < N; n++)
            words[n] = br.readLine();

        Arrays.sort(words);
        int cnt = N;
        for (int n = 0; n < N - 1; n++) {
            if (words[n + 1].startsWith(words[n])) cnt--;
        }
        System.out.println(cnt);
    }
}

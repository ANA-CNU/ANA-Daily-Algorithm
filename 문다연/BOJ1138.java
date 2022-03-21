package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import annotation.*;
@BOJ(   number = 1138,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 21))
public class BOJ1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int [] left = new int[N + 1];
        for (int n = 1; n <= N; n++) left[n] = Integer.parseInt(st.nextToken()) + 1;

        int [] line = new int[N + 1];
        for (int n = 1; n <=N; n++) {
            int ptr = 0;
            while (left[n] > 0) {
                ptr++;
                if (line[ptr] == 0) {
                    left[n]--;
                    if (left[n] == 0) line[ptr] = n;
                }
            }
        }

        for (int n = 1; n <= N; n++) System.out.print(line[n] + " ");
    }
}

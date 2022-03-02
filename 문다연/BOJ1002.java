package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import annotation.*;
@BOJ(   number = 1002,
        tier = BaekjoonTier.SILVER_IV,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 2))
public class BOJ1002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int d = (int) (Math.pow((y1 - y2), 2) +  Math.pow((x1 - x2), 2));
            int diff = (int) Math.pow(Math.max(r1, r2) - Math.min(r1, r2), 2);
            int sum = (int) Math.pow(r1 + r2, 2);

            if (d == 0 && r1 == r2) sb.append("-1\n");
            else if (d > r1 + r2 || d < diff || (d == 0 && r1 != r2)) sb.append("0\n");
            else if (d == r1 + r2 || d == diff) sb.append("1\n"); // 외접, 내접
            else sb.append("2\n"); // 두 점에서 만나는 경우
        }
        System.out.println(sb);
    }
}
/*
input
14
0 0 5 0 0 5
0 0 5 0 4 2
-30 40 50 -3 4 5
-1 8 10 -1 0 10
-6 3 9 -1 7 6
-2 3 8 1 2 5
2 9 6 10 9 10
0 0 1 3 4 5
1 3 1 3 2 1
0 0 7 6 0 2
0 0 2 1 0 1
0 0 1 0 0 1
0 0 10 0 1 1
0 0 6 0 1 4

output
-1
2
1
2
2
2
2
2
0
2
1
-1
0
0
 */
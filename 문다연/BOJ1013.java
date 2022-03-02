package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import annotation.*;
@BOJ(   number = 1013,
        tier = BaekjoonTier.GOLD_V,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 2))

public class BOJ1013 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String pattern = "^(100+1+|01)+$";
        for (int test_case = 0; test_case < T; test_case++) {
            if (Pattern.matches(pattern, br.readLine())) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}

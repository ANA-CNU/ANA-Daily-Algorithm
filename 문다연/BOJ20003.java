package BOJ;

import java.io.*;
import java.util.*;
import annotation.*;
@BOJ(   number = 20003,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 7))
public class BOJ20003 {
    public static long [] newCoin(long [] top, long [] bottom) {
        long newBottom = bottom[0];
        for (int i = 1; i < bottom.length; i++) newBottom = lcm(newBottom, bottom[i]);

        long newTop = top[0];
        for (int i = 1; i < top.length; i++) newTop = gcd(newTop, top[i]);

        return new long[]{newTop, newBottom};
    }

    static long gcd(long a, long b) { // 최대 공약수
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(st.nextToken());

        long [] top = new long [n];
        long [] bottom = new long [n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            top[i] = Long.parseLong(st.nextToken());
            bottom[i] = Long.parseLong(st.nextToken());
        }

        long [] ans = newCoin(top, bottom);
        long mod = gcd(ans[0], ans[1]);

        System.out.println((ans[0] / mod) + " " + (ans[1] / mod));
    }
}
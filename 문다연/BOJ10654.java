package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import annotation.*;
@BOJ(   number = 10654,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 13))
public class BOJ10654 {

    static int N, T;
    static boolean check(int [] top, int line, int speed) {
        if (top[1] <= speed) return false;
        return (line - top[0]) / (top[1] - speed) <= T;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        Stack<int []> stack = new Stack<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            while (!stack.empty() && check(stack.peek(), line, speed)) stack.pop();
            stack.push(new int[] {line, speed});
        }
        System.out.println(stack.size());
    }
}

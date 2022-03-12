package BOJ;

import java.io.*;
import java.util.*;
import annotation.*;
@BOJ(   number = 17299,
        tier = BaekjoonTier.GOLD_III,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 11))
public class BOJ17299 {
    static int N;
    static int [] frequency, A, ans;
    static Stack<int []> stack;
    static StringBuilder sb;

    static void NGF() {
        stack.push(new int[] {A[0], 0});

        for (int n = 1; n < N; n++) {
            while(!stack.isEmpty() && frequency[stack.peek()[0]] < frequency[A[n]]) {
                ans[stack.pop()[1]] = A[n];
            }
            stack.push(new int[] {A[n], n});
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        A = new int[N];
        ans = new int[N];
        frequency = new int[1_000_001];
        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
            frequency[A[n]]++;
        }

        NGF();
        for (int n = 0; n < N; n++) sb.append(ans[n] == 0 ? -1 : ans[n]).append(" ");
        System.out.println(sb);
    }
}

package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import annotation.*;
@BOJ(   number = 7795,
        tier = BaekjoonTier.SILVER_III,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 3))
public class BOJ7795 {
    static int getPair(int [] A, int [] B) {
        Arrays.sort(B);
        int right, cnt = 0;
        for (int a = 0; a < A.length; a++) {
            right = B.length - 1;
            while (right > 0) {

                if (A[a] > B[right]) break;
                else right--;

            }
            int rest = right + 1;
            if (rest == 1 && A[a] <= B[0]) {
                rest = 0;
            }
            cnt += rest;
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // number of test case
        int [] A, B;
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            A = new int[Integer.parseInt(st.nextToken())];
            B = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine());
            for (int a = 0; a < A.length; a++) A[a] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int b = 0; b < B.length; b++) B[b] = Integer.parseInt(st.nextToken());

            sb.append(getPair(A, B)).append("\n");
        }
        System.out.println(sb);
    }
}

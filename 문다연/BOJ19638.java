package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import annotation.*;
@BOJ(   number = 19638,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 15))
public class BOJ19638 {
    static int N, H, T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 인구 수
        H = Integer.parseInt(st.nextToken()); // 센티의 키
        T = Integer.parseInt(st.nextToken()); // 마법의 뿅망치 횟수 제한

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n = 0; n < N; n++) pq.add(Integer.parseInt(br.readLine()));

        int t;
        for (t = 0; t < T; t++) {

            if (pq.peek() < H) {
                System.out.println("YES");
                System.out.println(t);
                return;
            }

            if (pq.peek() == 1) break;
            pq.add(pq.poll() / 2);
        }

        if (pq.peek() < H) {
            System.out.println("YES");
            System.out.println(t);
        } else {
            System.out.println("NO");
            System.out.println(pq.poll());
        }
    }
}

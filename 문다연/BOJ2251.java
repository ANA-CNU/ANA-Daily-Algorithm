package BOJ;

import java.io.*;
import java.util.*;
import annotation.*;
@BOJ(   number = 2251,
        tier = BaekjoonTier.SILVER_I,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 26))
public class BOJ2251 {

    static int max;
    static int [] bottle;
    static boolean [][][] visit;
    static List<Integer> ans;
    static int cnt;

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, bottle[2]});

        /*
        경우의 수
        a -> b, a -> c
        b -> a, b -> c
        c -> a, c -> b
         */

        while (!queue.isEmpty()) {
            int a = queue.peek()[0];
            int b = queue.peek()[1];
            int c = queue.peek()[2];
            queue.poll();

            if (visit[a][b][c]) continue;
            visit[a][b][c] = true;
            if (a == 0)  ans.add(c);

            if (a + b > bottle[1]) queue.add(new int[] {a + b - bottle[1], bottle[1], c});
            else queue.add(new int[] {0, a + b, c});

            if (a + c > bottle[2]) queue.add(new int[] {a + c - bottle[2], b, bottle[2]});
            else queue.add(new int[] {0, b, a + c});

            if (b + a > bottle[0]) queue.add(new int[] {bottle[0], b + a - bottle[0], c});
            else queue.add(new int[] {b + a, 0, c});

            if (b + c > bottle[2]) queue.add(new int[] {a, b + c - bottle[2], bottle[2]});
            else queue.add(new int[] {a, 0, b + c});

            if (c + a > bottle[0]) queue.add(new int[] {bottle[0], b, c + a - bottle[0]});
            else queue.add(new int[] {c + a, b, 0});

            if (c + b > bottle[1]) queue.add(new int[] {a, bottle[1], c + b - bottle[1]});
            else queue.add(new int[] {a, c + b, 0});
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bottle = new int[3];
        bottle[0] = Integer.parseInt(st.nextToken());
        bottle[1] = Integer.parseInt(st.nextToken());
        bottle[2] = Integer.parseInt(st.nextToken());

        max = bottle[0] + bottle[1] + bottle[2] + 1;
        visit = new boolean[max][max][max];

        cnt = 0;
        ans = new ArrayList<>();
        bfs();
        Collections.sort(ans);
        for (int c = 0; c < ans.size(); c++) System.out.print(ans.get(c) + " ");

    }
}

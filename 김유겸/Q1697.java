package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {
    static int K;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        check = new int[100001];
        int answer = BFS(N);
        System.out.println(answer);
    }

    static int BFS(int root) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(root);
        check[root] = 1;
        while (!Q.isEmpty()) {
            int cv = Q.poll();
            if (cv == K) {
                return check[cv]-1;
            }
            if (2 * cv <= 100000 && check[2 * cv] == 0) {
                check[cv * 2] = check[cv] + 1;
                Q.offer(cv * 2);
            }
            if (cv + 1 <= 100000 && check[cv + 1] == 0) {
                check[cv + 1] = check[cv] + 1;
                Q.offer(cv + 1);
            }
            if (cv - 1 >= 0 && check[cv - 1] == 0) {
                check[cv - 1] = check[cv] + 1;
                Q.offer(cv - 1);
            }

        }
        return 0;
    }
}

package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] c = br.readLine().toCharArray();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = c[i] - '0';
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int removeCnt = 0;
        stack.push(num[i++]);
        while (i < N) {
            if (!stack.isEmpty() && stack.peek() < num[i] && removeCnt < K) {
                removeCnt++;
                stack.pop();
            } else {
                stack.push(num[i]);
                i++;
            }
        }
        while (removeCnt < K) {
            stack.pop();
            removeCnt++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}

package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] value = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int j = 1;
        for (int i = 1; i <= N; i++) {
            if (j <= value[i]) {
                for (; j <= value[i]; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
            } else if ( stack.peek() != value[i]) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}

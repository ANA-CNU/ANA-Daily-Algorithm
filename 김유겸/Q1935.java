package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                stack.push((double) arr[ch - 'A']);
            } else {
                double a = stack.pop();
                double b = stack.pop();
                double c = 0;
                switch (ch) {
                    case '+':
                        c = b+a;
                        break;
                    case '-':
                        c = b-a;
                        break;
                    case '*':
                        c = b * a;
                        break;
                    case '/':
                        c = b / a;
                        break;
                }
                stack.push(c);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}

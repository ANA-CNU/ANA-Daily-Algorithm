package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] num = new int[1000001];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            num[arr[i]] += 1;
        }

        for(int i = 0; i < N; i++){
            while (!stack.isEmpty() && num[arr[i]] > num[arr[stack.peek()]]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) arr[stack.pop()] = -1;
        StringBuilder sb = new StringBuilder();
        for(int a : arr) sb.append(a).append(" ");
        System.out.println(sb);
    }
}

package done;

import java.io.*;
import java.util.*;

public class backjoon_1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        StringTokenizer st;
        stack.push(0);

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int item = Integer.parseInt(st.nextToken());

            if (stack.peek() < item) {
                stack.push(item);
            }else if (stack.peek() > item) {
                while (stack.peek() > item) {
                    stack.pop();
                    sum++;
                }
                if (stack.peek() < item) stack.push(item);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != 0) sum++;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
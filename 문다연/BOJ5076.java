package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import annotation.*;
@BOJ(   number = 5076,
        tier = BaekjoonTier.GOLD_IV,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 12))
public class BOJ5076 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack<String> stack = new Stack<>();
        String line;
        boolean flag;

        while (!(line = br.readLine()).equals("#")) {
            if (!line.contains("<")) {
                sb.append("legal\n");
                continue;
            }
            stack.clear();
            flag = true;
            st = new StringTokenizer(line, "<");
            while (st.hasMoreTokens() && flag) {
                String [] split = st.nextToken().split(">");
                String next = split[0];

                if (stack.isEmpty()) {
                    if (next.charAt(0) == 'a') next = "a";
                    stack.push(next);
                } else {
                    if (next.charAt(0) == '/') {
                        String keyword = next.split("/")[1];
                        if (stack.peek().equals(keyword)) {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        if (next.contains("/")) continue;
                        stack.push(next);
                    }
                }
            }
            if (!stack.isEmpty()) flag = false;
            sb.append(flag ? "legal\n" : "illegal\n");
        }
        System.out.println(sb);
    }
}

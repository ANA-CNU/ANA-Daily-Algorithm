import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);
        Stack<String> stack = new Stack<>();
        stack.add(arr[0]);

        for(int i = 1; i < N; i++) {
            String current = stack.pop();
            String next = arr[i];
            boolean flag = false;
            int min = Math.min(current.length(), next.length());
            for(int j = 0; j < min; j++) {
                if(current.charAt(j) != next.charAt(j)) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                stack.push(current);
                stack.push(next);
            }else{
                stack.push(next);
            }
        }

        System.out.println(stack.size());
    }
}

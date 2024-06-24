import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 0) {
                stack.push(a);
            } else if (a == 0){
                stack.pop();
            }
        }

        int sum = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }

        bw.write(sum + "");
        bw.close();
    }
}

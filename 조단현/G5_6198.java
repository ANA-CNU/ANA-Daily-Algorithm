import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class G5_6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i<N; i++){
            int input = Integer.parseInt(br.readLine());

            if(stack.isEmpty()) stack.add(input);

            else if(stack.peek() > input){
                stack.add(input);
            }
            else if(stack.peek() <= input){
                    while (stack.size() != 0 && stack.peek() <= input) {
                        stack.pop();
                    }
                    stack.add(input);
            }

            if(stack.size() >= 1) {
                sum += stack.size() - 1;

            }



        }


        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}

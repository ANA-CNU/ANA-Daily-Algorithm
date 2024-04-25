import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        int start = 0;
        for(int i = 0; i < K; i++){
            int value = Integer.parseInt(br.readLine());
            if(value > start){
                for(int j = start + 1; j <= value; j++){
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = value;

            }else if(stack.peek() != value){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');


        }
        System.out.println(sb);


    }

}

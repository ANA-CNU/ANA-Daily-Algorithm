import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek6198_again {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        long result = 0L;

        Stack <Integer> stack = new Stack<>();
        int [] arr = new int[input];
        for(int i=0;i<input;i++){

            arr[i]= Integer.parseInt(br.readLine());
        }
        for(int i=0;i<input;i++){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){

                stack.pop();

            }
            stack.push(arr[i]);
            result += stack.size() - 1;

        }
        System.out.println(result);

    }
}

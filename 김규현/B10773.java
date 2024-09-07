import java.io.*;
import java.util.*;

public class B10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp !=0){
                stack.push(temp);
            }
            else{
                stack.pop();
            }
        }
       int stackSize = stack.size();
        int sum = 0;
        for(int i = 0; i < stackSize; i++){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}

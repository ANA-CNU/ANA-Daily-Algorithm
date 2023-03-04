import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }//입력 받은 수열
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx=1;
        boolean test = true;
        for(int i=1; i<=n; i++){
            stack.push(i);
            sb.append("+").append("\n");
            while(stack.peek().equals(arr[idx])){
                stack.pop();
                sb.append("-").append("\n");
                idx++;
                if(stack.empty()){
                    break;
                }
                if(arr[idx]<stack.peek()){
                    test=false;
                    System.out.println("NO");
                    break;
                }
            }
        }
        if(test){
            System.out.println(sb);
        }
    }
}

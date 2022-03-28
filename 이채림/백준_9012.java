import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String result = "YES";
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                char c = line.charAt(j);
                if(c=='('){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        result = "NO";
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()){
                result = "NO";
            }
            System.out.println(result);
        }
    }
}
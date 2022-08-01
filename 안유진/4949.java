import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = "?";

        while(true){
            s = br.readLine();

            if(s.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();
            int changedcheck = 0;

            for(int i = 0; i < s.length(); i++){

                char ch = s.charAt(i);

                if(ch ==  '(' || ch == '['){
                    stack.push(ch);

                }else if(ch == ')'){
                    if(stack.empty() || stack.peek() != '('){
                        changedcheck = 1;
                        break;
                    }else{
                        stack.pop();
                    }

                }else if(ch == ']'){
                    if(stack.empty() || stack.peek() != '['){
                        changedcheck = 1;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(stack.empty() && changedcheck == 0){
                sb.append("yes").append('\n');
            }else if(changedcheck != 0){
                sb.append("no").append('\n');
            }else{
                sb.append("no").append('\n');
            }
        }

        System.out.println(sb);
    }
}

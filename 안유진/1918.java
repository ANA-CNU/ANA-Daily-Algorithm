import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hororop{
    static Stack<Character> stack = new Stack<>();
    static int check(char ch){
        if(ch == '*' || ch == '/'){ // +나 - 보다 우선순위 우위임
            return 1;
        }else if(ch == '-' || ch == '+'){ //+ 와 - 인경우
            return 2;
        }else{ //괄호는 빠지면 안됨 가장크게해줌
            return 3;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch >= 65 && ch <= 90){ //문자라면
                sb.append(ch); //답에 추가해줌
            }else{
                if(stack.isEmpty()){
                    stack.push(ch);
                }else{
                    if(ch == '('){
                        stack.push(ch);
                    }else if(ch == ')'){
                        while (!stack.isEmpty() && !(stack.peek() == '(')){
                            sb.append(stack.pop());
                        }
                        stack.pop();
                    }else{
                        while (!stack.isEmpty() && check(stack.peek()) <= check(ch)){
                            sb.append(stack.pop());
                        }
                        stack.push(ch);
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}



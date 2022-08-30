import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int number(Character ch){
        if(ch == 'H'){ //수소!!
            return 1;
        }else if(ch == 'C'){ //탄소!!
            return 12;
        }else{ //산소!!
            return 16;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){ //0으로 대체해서 push
                stack.push(0);
            }else if(ch == 'H' || ch == 'C' || ch == 'O'){
                stack.push(number(ch));
            }else if(ch == ')'){
                int tempsum = 0;
                while (stack.peek() != 0){
                    tempsum += stack.pop();
                }
                stack.pop();
                stack.push(tempsum);
            }else{ //그냥 숫자
                int num = ch - '0';
                int temp = stack.pop();
                stack.push(temp * num);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Rulu {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();

        boolean flag = true;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(-1);
            }
            else if(ch == '['){
                stack.push(-2);
            }
            else if(ch == ')'){ //닫는거 나와서 빼야함
                if(stack.isEmpty()){
                    flag = false;
                    break;
                }
                int sum = 0;
                boolean check = false;

                while (!stack.isEmpty()){
                    int temp = stack.pop();
                    if(temp == -2){
                        break;
                    }
                    if(temp == -1){
                        check = true;
                        break;
                    }else{
                        sum += temp;
                    }
                }

                if(!check){
                    flag = false;
                    break;
                }

                if(sum == 0){
                    stack.push(2);
                }else{
                    stack.push(2 * sum);
                }
            }
            else if(ch == ']'){
                if(stack.isEmpty()){
                    flag = false;
                    break;
                }
                int sum = 0;
                boolean check = false;

                while (!stack.isEmpty()){
                    int temp = stack.pop();
                    if(temp == -1){
                        break;
                    }
                    if(temp == -2){
                        check = true;
                        break;
                    }else{
                        sum += temp;
                    }
                }

                if(!check){
                    flag = false;
                    break;
                }

                if(sum == 0){
                    stack.push(3);
                }else{
                    stack.push(3 * sum);
                }
            }
            else{
                flag = false;
            }
        }

        if(!flag){
            System.out.println(0);
        }else{
            int sum = 0;
            boolean check = true;
            while (!stack.isEmpty()){
                int temp = stack.pop();
                if(temp == -1 || temp == -2){
                    check = false;
                    break;
                }else{
                    sum += temp;
                }
            }

            if(check){
                System.out.println(sum);
            }else{
                System.out.println(0);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] st = br.readLine().split(" ");
            if(st[0].equals("push")){
                stack.push(st[1]);
            }else if(st[0].equals("pop")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(stack.pop());
                }
            }else if(st[0].equals("size")){
                System.out.println(stack.size());
            }else if(st[0].equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(st[0].equals("top")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(stack.peek());
                }
            }
        }
        

    }
}

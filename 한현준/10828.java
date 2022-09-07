import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack1 = new Stack<>();

//        Scanner sc = new Scanner(System.in);

        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufReader.readLine());

        for(int i = 0; i<n; i++){
            StringTokenizer token1 = new StringTokenizer(bufReader.readLine(), " ");
            String s1 = token1.nextToken();
            if(s1.equals("push")){
                stack1.push(Integer.parseInt(token1.nextToken()));
            }
            else if(s1.equals("pop")){
                if(stack1.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack1.pop());
                }
            }
            else if(s1.equals("size")){
                System.out.println(stack1.size());
            }
            else if(s1.equals("empty")){
                if(stack1.isEmpty()){
                    System.out.println("1");
                }
                else{
                    System.out.println("0");
                }
            }
            else if(s1.equals("top")){
                if(stack1.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack1.peek());
                }
            }
        }

        bufReader.close();
    }
}

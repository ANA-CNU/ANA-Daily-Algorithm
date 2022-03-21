import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Stack<Integer> stack = new Stack<>();

       int k = Integer.parseInt(br.readLine());

       for(int i = 0; i<k; i++){
           int num = Integer.parseInt(br.readLine());

           if(num == 0){
               stack.pop();
           }else{
               stack.push(num);
           }
       }
       //1,6 left
        //6
        //1
       int sum = 0;
       int size = stack.size();
       for(int i = 0; i<size; i++){
           sum+=stack.peek();
           stack.pop();
       }
       //stack size: 2
        //0, 1(2번)
        //0번쨰 turn: peek 6 -> sum=6 ->6 pop
        //1 : peek 1 -> sum = 7

        System.out.println(sum);
    }
}

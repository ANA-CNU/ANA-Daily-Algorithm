import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       Deque<Integer> deque = new ArrayDeque<>();

       int N = Integer.parseInt(br.readLine());
       deque.addLast(N);

       int number = N;

       if(number != 1){
           deque.addFirst(number - 1);
           while (true){
               number -= 1;
               for(int i = 0; i < number; i++){
                   int temp = deque.removeLast();
                   deque.addFirst(temp);
               }
               if(number == 1){
                   break;
               }
               deque.addFirst(number-1);
           }
       }

       for(int num : deque){
           sb.append(num+" ");
       }
        System.out.println(sb);
    }
}


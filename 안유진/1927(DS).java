import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       PriorityQueue<Integer> queue = new PriorityQueue<>();

       int N = Integer.parseInt(br.readLine());

       for(int i = 0; i < N; i++){
           int num = Integer.parseInt(br.readLine());
           try {
               if(num == 0){
                   sb.append(queue.remove()).append('\n');
               }else{
                   queue.add(num);
               }
           }catch(NoSuchElementException e){
               sb.append(0).append('\n');
           }
       }

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_2164 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            queue.add(i);
        }
      
        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
        
    }
   
}

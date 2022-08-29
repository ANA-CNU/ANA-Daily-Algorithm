import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hororop{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i < N+1; i++){
            deque.addLast(i);
        }

        while (deque.size() != 1){
            sb.append(deque.removeFirst()).append(" ");
            int temp = deque.removeFirst();
            deque.addLast(temp);
        }
        sb.append(deque.removeFirst());
        System.out.println(sb);
    }
}
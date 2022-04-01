import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_11866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]);
        int K = Integer.parseInt(st[1]);
        
        int[] result = new int[N];

        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        for(int i = 0; i < N; i++){
            for(int j=0; j<K-1; j++){
                queue.add(queue.poll());
            }
            result[i] = queue.poll();
        }
        
        System.out.print("<");
        for(int i = 0; i < N-1; i++){
            System.out.print(result[i] + ", ");
        }
        System.out.print(result[N-1]+">");
    }   
}

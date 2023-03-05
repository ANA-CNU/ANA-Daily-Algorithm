import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        int[] numbers = new int[N+1];
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        /*LinkedList<Integer> ls = new LinkedList<>();
        for(int i=1; i<=N; i++){
            ls.add(i);
        }
        while(!ls.isEmpty()){
            idx = (idx+(K-1))%ls.size();
            sb.append(ls.remove(idx)).append(", ");
        }*/
        Deque<Integer> deque = new LinkedList<>();
        while (!queue.isEmpty()){
            for(int i=0; i<K-1; i++){
                queue.add(queue.pollFirst());
            }
            deque.add(queue.pop());
        }
        sb.append("<");
        for(int i=0; i<N; i++){
            sb.append(deque.pop());
            if(i!=N-1){
                sb.append(", ");
            }
            else sb.append(">");
        }
        System.out.println(sb);
    }
}

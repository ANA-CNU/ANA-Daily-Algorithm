import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Horororo {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < N+1; i++){
            queue.offer(i);
        }
        while(queue.size() != 1){
            queue.poll();
            queue.add(queue.remove());
        }
        System.out.println(queue.element());
    }
}
//1. N을 입력받는다
//2. 크기 N의 큐를 만든다
//3. 큐의 size가 1이될때까지 재귀를돌림
//4. 한 스텝이 pop(제거용) + pop(뒤에 다시 추가)

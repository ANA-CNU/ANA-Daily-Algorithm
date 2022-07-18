import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<N+1; i++){
            queue.add(i);
        }

        while(queue.size()!=1){
            for(int i = 0; i < K; i++){
                if(i != K-1){
                    int num = queue.remove();
                    queue.add(num);
                }else{
                    sb.append(queue.remove()).append(", ");
                }
            }
        }
        sb.append(queue.remove()).append(">");
        System.out.println(sb);
    }
}
//1.큐를 생성함(크기는 N)
//2.1~N까지 숫자를 다 넣어서 큐 초기화함
//3. 큐에 원소가 하나남을때까지 빌더에 추가하고 제거해줌
//4. 제거는 K번째라고했으니 for문으로
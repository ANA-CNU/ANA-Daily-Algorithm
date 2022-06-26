import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            if(st.countTokens() > 1){
                String token = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(token.equals("push_back")){
                    deque.offerLast(num);
                }
                if(token.equals("push_front")){
                    deque.offerFirst(num);
                }
            }else{
                String token = st.nextToken();
                if(token.equals("pop_front")){
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.removeFirst()).append('\n');
                    }
                }else if(token.equals("pop_back")){
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.removeLast()).append('\n');
                    }
                }else if(token.equals("size")){
                    sb.append(deque.size()).append('\n');
                }else if(token.equals("empty")){
                    if(deque.isEmpty()){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                }else if(token.equals("front")){
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.getFirst()).append('\n');
                    }
                }else if(token.equals("back")){
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.getLast()).append('\n');
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

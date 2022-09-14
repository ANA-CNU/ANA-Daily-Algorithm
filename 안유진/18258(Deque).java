import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            if(st.countTokens() == 2){
                String s = st.nextToken();
                int temp = Integer.parseInt(st.nextToken());
                deque.addLast(temp);
            }else{
                String s = st.nextToken();
                if(s.equals("pop")){
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(deque.removeFirst()).append('\n');
                    }
                }else if(s.equals("size")){
                    sb.append(deque.size()).append('\n');
                }else if(s.equals("empty")){
                    if(deque.isEmpty()){
                        sb.append(1).append('\n');
                    }else {
                        sb.append(0).append('\n');
                    }
                }else if(s.equals("front")){
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.peekFirst()).append('\n');
                    }
                }else if(s.equals("back")){
                    if(deque.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(deque.peekLast()).append('\n');
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

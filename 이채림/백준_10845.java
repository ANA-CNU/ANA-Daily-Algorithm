import java.io.*;
import java.util.*;

public class 백준_10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>() ;
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] st = br.readLine().split(" ");

            if(st.length == 2){
                // push
                queue.add(Integer.parseInt(st[1]));
            }else{
                if(st[0].equals("front")){
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.getFirst());
                    }
                }else if(st[0].equals("back")){
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.getLast());
                    }
                }else if(st[0].equals("pop")){
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.pollFirst());
                    }

                }else if(st[0].equals("size")){
                    System.out.println(queue.size());
                }else if(st[0].equals("empty")){
                    if(queue.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                }
            }
        }
    }
}
